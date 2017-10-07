package com.nazar.dao;

import com.nazar.controller.FrontController;
import com.nazar.util.Config;
import org.apache.log4j.Logger;

import java.sql.Connection;

public abstract class DaoFactory {
    private static final Logger LOGGER = Logger.getLogger(DaoFactory.class);

    public abstract UserDao getUserDao(Connection connection);
    public abstract AccountDao getAccountDao(Connection connection);
    public abstract CardDao getCardDao(Connection connection);

    public abstract Connection getConnection();

    public static DaoFactory getInstance(){
        String className = Config.getInstance().getFactoryClassName();
        DaoFactory factory = null;
        try {
            factory = (DaoFactory) Class.forName(className).newInstance();
        } catch (Exception e) {
            LOGGER.error("Error while attempting to get instance of DAO factory");
            e.printStackTrace();
        }
        return factory;
    }
}
