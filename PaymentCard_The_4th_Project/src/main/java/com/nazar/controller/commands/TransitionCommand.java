package com.nazar.controller.commands;

import com.nazar.controller.ControllerCommand;
import com.nazar.service.AccountService;
import com.nazar.service.impl.AccountServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.nazar.util.GlobalConst.CURRENT_ACCOUNT;
import static com.nazar.util.GlobalConst.CURRENT_ACCOUNT_ID;
import static com.nazar.util.GlobalConst.PATH;

public class TransitionCommand implements ControllerCommand {
    private AccountService accountService;

    public TransitionCommand() {
        accountService = AccountServiceImpl.getInstance();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        int accountId = Integer.parseInt(request.getParameter(CURRENT_ACCOUNT_ID));
        session.setAttribute(CURRENT_ACCOUNT, accountService.getAccountById(accountId));
        return request.getParameter(PATH);
    }
}
