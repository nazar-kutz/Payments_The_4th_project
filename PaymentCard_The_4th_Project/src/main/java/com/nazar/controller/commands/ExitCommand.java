package com.nazar.controller.commands;

import com.nazar.controller.ControllerCommand;
import com.nazar.util.PathManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.nazar.util.GlobalConst.USER;

public class ExitCommand implements ControllerCommand{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.setAttribute(USER, null);
        return PathManager.getInstance().getLoginUri();
    }
}
