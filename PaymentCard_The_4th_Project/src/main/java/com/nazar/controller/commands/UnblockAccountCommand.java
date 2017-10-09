package com.nazar.controller.commands;

import com.nazar.controller.ControllerCommand;
import com.nazar.controller.FrontController;
import com.nazar.controller.UserSessionUpdater;
import com.nazar.dto.Account;
import com.nazar.dto.reports.UnblockedAccountsReport;
import com.nazar.service.AccountService;
import com.nazar.service.impl.AccountServiceImpl;
import com.nazar.util.PathManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

import static com.nazar.util.GlobalConst.REPORTS;
import static com.nazar.util.GlobalConst.UNBLOCK_ITEM;

public class UnblockAccountCommand implements ControllerCommand, UserSessionUpdater {
    public static final Logger LOGGER = Logger.getLogger(UnblockAccountCommand.class);

    private AccountService accountService;
    private PathManager pathManager;
    List<UnblockedAccountsReport> reports;

    public UnblockAccountCommand() {
        accountService = AccountServiceImpl.getInstance();
        pathManager = PathManager.getInstance();
        reports = new ArrayList<>();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String[] values = request.getParameterValues(UNBLOCK_ITEM);
        if(values == null){
            return pathManager.getAdminUnblockingInfoUri();
        }
        for(String accountId : values){
            UnblockedAccountsReport report = new UnblockedAccountsReport();
            try {
                Account account = accountService.getAccountById(Integer.parseInt(accountId));
                accountService.unblock(account);
                report.setInfo(account.getId());
            } catch (Exception e){
                LOGGER.error("Error while attempting to unblock account. " + e.getMessage());
                report.setInfo(e);
            }
            reports.add(report);
        }

        request.getSession().setAttribute(REPORTS, reports);
        updateUser(request, response);
        return pathManager.getAdminUnblockingInfoUri();
    }
}
