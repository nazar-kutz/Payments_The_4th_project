package com.nazar.controller.commands;

import com.nazar.controller.ControllerCommand;
import com.nazar.dto.User;
import com.nazar.dto.UserRole;
import com.nazar.service.AccountService;
import com.nazar.service.UserService;
import com.nazar.service.impl.AccountServiceImpl;
import com.nazar.service.impl.UserServiceImpl;
import com.nazar.util.PathManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Calendar;

import static com.nazar.util.GlobalConst.*;
import static com.nazar.util.FormatConverter.convertPhoneNumberToStandardPerformance;

public class LoginCommand implements ControllerCommand {
    private UserService userService;
    private PathManager pathManager;

    public LoginCommand() {
        userService = UserServiceImpl.getInstance();
        pathManager = PathManager.getInstance();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        UserService userService = UserServiceImpl.getInstance();
        String login = convertPhoneNumberToStandardPerformance(request.getParameter(LOGIN));
        String password = request.getParameter(PASSWORD);

        try {
            User user = userService.login(login, password);
            user.setLastVisitDate(Calendar.getInstance());
            userService.updateUser(user);

            return nextPage(request, user);
        } catch (Exception e){

            request.setAttribute(ERROR, e.getMessage());
            return pathManager.getLoginUri();
        }
    }

    protected String nextPage(HttpServletRequest request, User user) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute(USER, user);
        session.setAttribute("pathManager", pathManager);
        if (UserRole.ADMIN.equals(user.getRole())){

            AccountService accountService = AccountServiceImpl.getInstance();
            session.setAttribute(TO_UNBLOCK_LIST, accountService.getAllAccountsToUnblock());

            return PathManager.getInstance().getAdminCabinetUri();
        } else {
            return PathManager.getInstance().getUserCabinetUri();
        }
    }
}
