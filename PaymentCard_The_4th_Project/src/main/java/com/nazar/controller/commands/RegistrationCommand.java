package com.nazar.controller.commands;

import com.nazar.controller.ControllerCommand;
import com.nazar.controller.FrontController;
import com.nazar.service.UserService;
import com.nazar.service.impl.UserServiceImpl;
import com.nazar.util.PathManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

import static com.nazar.util.GlobalConst.*;
import static com.nazar.util.FormatConverter.convertPhoneNumberToStandardPerformance;

public class RegistrationCommand implements ControllerCommand {
    public static final Logger LOGGER = Logger.getLogger(RegistrationCommand.class);

    private UserService userService;

    public RegistrationCommand() {
        this.userService = UserServiceImpl.getInstance();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> userDetails = new HashMap<>();
        PathManager pathManager = PathManager.getInstance();
        try {
            userDetails.put(FIRST_NAME, request.getParameter(FIRST_NAME));
            userDetails.put(LAST_NAME, request.getParameter(LAST_NAME));
            userDetails.put(PATRONYMIC, request.getParameter(PATRONYMIC));
            userDetails.put(PHONE, convertPhoneNumberToStandardPerformance(request.getParameter(PHONE)));
            userDetails.put(PASSWORD, request.getParameter(PASSWORD));

            userService.createUser(userDetails);
        } catch (Exception e) {
            LOGGER.error("Error while attempting to register a new user. " + e.getMessage());
            request.setAttribute(ERROR, e.getMessage());
            return pathManager.getRegistrationUri();
        }
        return pathManager.getLoginUri();
    }
}
