package com.nazar.dao;

import com.nazar.dao.exception.PersistsException;
import com.nazar.dto.User;

import java.sql.SQLException;
import java.util.Optional;

public interface UserDao extends GenericDao<User>{
    Optional<User> findUserByLoginAndPassword(String login, String password) throws PersistsException;

    String getUserLoginPasswordQuery();

    boolean existLogin(String login) throws PersistsException;

    String getUserExistsQuery();
}
