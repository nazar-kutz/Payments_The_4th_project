package com.nazar.controller.commands;

import com.nazar.controller.AccountChecker;
import com.nazar.controller.ControllerCommand;
import com.nazar.controller.FrontController;
import com.nazar.controller.UserSessionUpdater;
import com.nazar.controller.exception.NoAccessToAccountException;
import com.nazar.dto.Account;
import com.nazar.dto.reports.ReplenishmentReport;
import com.nazar.service.AccountService;
import com.nazar.service.impl.AccountServiceImpl;
import com.nazar.util.PathManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Calendar;

import static com.nazar.util.GlobalConst.*;

public class ReplenishCommand implements ControllerCommand, UserSessionUpdater, AccountChecker {
    public static final Logger LOGGER = Logger.getLogger(ReplenishCommand.class);

    private AccountService accountService;
    private PathManager pathManager;

    public ReplenishCommand() {
        accountService = AccountServiceImpl.getInstance();
        pathManager = PathManager.getInstance();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            Account account = (Account)session.getAttribute(CURRENT_ACCOUNT);

            if(!accountBelongsToUser(request, account)){
                throw new NoAccessToAccountException(account.getId());
            }

            long replenishmentAmountInCoins = (long)(Double.parseDouble(request.getParameter(REPLENISHMENT_AMOUNT))*100);
            accountService.replenish(account, replenishmentAmountInCoins);

            //create a new replenishment report to view for user
            ReplenishmentReport report = ReplenishmentReport.getBuilder()
                    .buildAccountId(account.getId())
                    .buildAmount(replenishmentAmountInCoins)
                    .buildDate(Calendar.getInstance())
                    .build();
            request.setAttribute(REPORT, report);
            updateUser(request, response);

            return pathManager.getUserReplenishInfoUri();
        } catch (Exception e) {
            LOGGER.error("Error while attempting to replenish. " + e.getMessage());
            request.setAttribute(ERROR, e.getMessage());
            return pathManager.getUserReplenishUri();
        }
    }
}
