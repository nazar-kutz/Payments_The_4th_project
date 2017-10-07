package com.nazar.controller;

import com.nazar.dto.User;
import com.nazar.service.UserService;
import com.nazar.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.nazar.util.GlobalConst.USER;

public interface UserSessionUpdater {
    default void updateUser(HttpServletRequest request, HttpServletResponse response){
        try {
            HttpSession session = request.getSession();
            UserService userService = UserServiceImpl.getInstance();
            User user = (User)session.getAttribute(USER);
            session.setAttribute(USER, userService.getUserById(Math.toIntExact(user.getId())));
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
