package com.nazar.controller.commands;

import com.nazar.controller.AccountChecker;
import com.nazar.controller.ControllerCommand;
import com.nazar.controller.FrontController;
import com.nazar.controller.UserSessionUpdater;
import com.nazar.controller.exception.NoAccessToAccountException;
import com.nazar.dto.Account;
import com.nazar.dto.reports.PaymentReport;
import com.nazar.service.AccountService;
import com.nazar.service.exception.AccountIsBlockedException;
import com.nazar.service.exception.NotEnoughMoneyException;
import com.nazar.service.impl.AccountServiceImpl;
import com.nazar.util.PathManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Calendar;

import static com.nazar.util.GlobalConst.*;

public class PaymentCommand implements ControllerCommand, UserSessionUpdater, AccountChecker {
    public static final Logger LOGGER = Logger.getLogger(PaymentCommand.class);

    private AccountService accountService;
    private PathManager pathManager;

    public PaymentCommand() {
        accountService = AccountServiceImpl.getInstance();
        pathManager = PathManager.getInstance();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            Account sender = (Account) session.getAttribute(CURRENT_ACCOUNT);

            long recipientId = Long.parseLong(request.getParameter(RECIPIENT));
            Account recipient = accountService.getAccountById((int) recipientId);

            long replenishmentAmountInCoins = (long) (Double.parseDouble(request.getParameter(SUM_TO_PAYMENT)) * 100);

            check(request, sender, recipient, replenishmentAmountInCoins);

            accountService.doPayment(sender, recipient, replenishmentAmountInCoins);

            //create a new payment report to view for user
            PaymentReport report = PaymentReport.getBuilder()
                    .buildAccountId(sender.getId())
                    .buildRecipient(recipientId)
                    .buildAmount(replenishmentAmountInCoins)
                    .buildDate(Calendar.getInstance())
                    .build();
            request.setAttribute(REPORT, report);
            updateUser(request, response);
            return pathManager.getUserPaymentInfoUri();
        } catch (Exception e) {
            LOGGER.error("Error while attempting to do payment. " + e.getMessage());
            request.setAttribute(ERROR, e.getMessage());
            return pathManager.getUserPaymentUri();
        }
    }

    public void check(HttpServletRequest request, Account sender, Account recipient, long replenishmentAmountInCoins){
        if(!accountBelongsToUser(request, sender)){
            throw new NoAccessToAccountException(sender.getId());
        }
        if(replenishmentAmountInCoins > sender.getBalance()){
            throw new NotEnoughMoneyException(sender.getBalance(), replenishmentAmountInCoins);
        }
        if(sender.isBlocked() || recipient.isBlocked()){
            throw new AccountIsBlockedException();
        }
    }
}