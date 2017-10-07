package com.nazar.controller.commands;

import com.nazar.controller.ControllerCommand;
import com.nazar.controller.FrontController;
import com.nazar.controller.UserSessionUpdater;
import com.nazar.dto.Account;
import com.nazar.service.AccountService;
import com.nazar.service.impl.AccountServiceImpl;
import com.nazar.util.PathManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.nazar.util.GlobalConst.CURRENT_ACCOUNT_ID;
import static com.nazar.util.GlobalConst.ERROR;

public class BlockAccountCommand implements ControllerCommand, UserSessionUpdater {
    public static final Logger LOGGER = Logger.getLogger(BlockAccountCommand.class);

    private AccountService accountService;
    private PathManager pathManager;

    public BlockAccountCommand() {
        accountService = AccountServiceImpl.getInstance();
        pathManager = PathManager.getInstance();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            Account account = accountService.getAccountById(Integer.parseInt(request.getParameter(CURRENT_ACCOUNT_ID)));
            accountService.block(account);
            updateUser(request, response);
        } catch (Exception e){
            LOGGER.error("Error while attempting to block account. " + e.getMessage());
            request.setAttribute(ERROR, e.getMessage());
        }
        return pathManager.getUserAccountReviewUri();
    }
}
