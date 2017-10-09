package com.nazar.controller;

import com.nazar.dto.Account;
import com.nazar.dto.User;

import javax.servlet.http.HttpServletRequest;

import static com.nazar.util.GlobalConst.USER;

public interface AccountChecker {
    default boolean accountBelongsToUser(HttpServletRequest request, Account account){
        User user = (User)request.getSession().getAttribute(USER);
        if (user.getAccounts().contains(account)){
            return true;
        }
        return false;
    }
}
