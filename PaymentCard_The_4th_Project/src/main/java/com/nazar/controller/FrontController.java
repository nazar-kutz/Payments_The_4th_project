package com.nazar.controller;

import com.nazar.controller.commands.*;
import com.nazar.controller.commands.BlockAccountCommand;
import com.nazar.controller.commands.UnblockAccountCommand;
import com.nazar.controller.commands.UnblockRequestCommand;
import com.nazar.controller.exception.NoSuchPathException;
import com.nazar.util.PathManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FrontController {
    public static final Logger LOGGER = Logger.getLogger(FrontController.class);

    private Map<String, ControllerCommand> commands = new HashMap<>();

    private FrontController() {
        initCommands();
    }

    private static class Holder {
        private static final FrontController INSTANCE = new FrontController();
    }

    public static FrontController getInstance() {
        return Holder.INSTANCE;
    }

    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();
        ControllerCommand command = findCommand(path);

        if(command != null){
            LOGGER.info("Do command: " + path);
            String resultPath = command.execute(request, response);
            request.getRequestDispatcher(resultPath).forward(request, response);
        } else {
            LOGGER.error("Error! No a such path: " + path);
            throw new NoSuchPathException(request.getRequestURI());
        }
    }

    public ControllerCommand findCommand(String path) {
        if (commands.containsKey(path)) {
            return commands.get(path);
        } else {
            return null;
        }
    }

    private void initCommands() {
        PathManager pathManager = PathManager.getInstance();
        commands.put(pathManager.getUnblockAccountCommandPath(), new UnblockAccountCommand());
        commands.put(pathManager.getUnblockRequestCommandPath(), new UnblockRequestCommand());
        commands.put(pathManager.getBlockAccountCommandPath(), new BlockAccountCommand());
        commands.put(pathManager.getRegistrationCommandPath(), new RegistrationCommand());
        commands.put(pathManager.getTransitionCommandPath(), new TransitionCommand());
        commands.put(pathManager.getReplenishCommandPath(), new ReplenishCommand());
        commands.put(pathManager.getLanguageCommandPath(), new LanguageCommand());
        commands.put(pathManager.getPaymentCommandPath(), new PaymentCommand());
        commands.put(pathManager.getLoginCommandPath(), new LoginCommand());
        commands.put(pathManager.getExitCommandPath(), new ExitCommand());
    }
}
