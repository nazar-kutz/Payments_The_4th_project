package com.nazar.dao.impl;

import com.nazar.util.Config;
import com.nazar.dao.AccountDao;
import com.nazar.dao.CardDao;
import com.nazar.dao.DaoFactory;
import com.nazar.dao.UserDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDaoFactory extends DaoFactory {
    @Override
    public UserDao getUserDao(Connection connection) {
        return new MySqlUserDao(getConnection());
    }

    @Override
    public AccountDao getAccountDao(Connection connection) {
        return new MySqlAccountDao(getConnection());
    }

    @Override
    public CardDao getCardDao(Connection connection) {
        return new MySqlCardDao(getConnection());
    }

    @Override
    public Connection getConnection(){
        Config config = Config.getInstance();
        Connection connection;
        try {
            Object mysqlDrv = Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager
                    .getConnection( config.getUrl() , config.getUser(),
                            config.getPass() );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}