package com.nazar.service;

import com.nazar.dto.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface UserService {
    User getUserById(int userId);

    List<User> getAllUsers() throws SQLException;

    User login(String login, String password);

    void updateUser(User user);

    Long createUser(Map<String, String> userDetails);

    //where should I log in user?
}
