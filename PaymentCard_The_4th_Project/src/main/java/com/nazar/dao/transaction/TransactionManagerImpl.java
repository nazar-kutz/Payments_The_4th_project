package com.nazar.dao.transaction;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionManagerImpl implements TransactionManager {
    private static final Logger LOGGER = Logger.getLogger(TransactionManagerImpl.class);

    private Connection connection;
    private boolean inProcess = false;

    public TransactionManagerImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void begin() {
        try{
            connection.setAutoCommit(false);
            inProcess = true;
            LOGGER.info("Start transaction...");
        } catch (SQLException e){
            LOGGER.error("Error while beginning of transaction");
        }
    }

    @Override
    public void commit() {
        try{
            connection.commit();
            connection.setAutoCommit(true);
            inProcess = false;
            LOGGER.info("Commit transaction...");
        } catch (SQLException e) {
            LOGGER.error("Error while committing of transaction");
        }
    }

    @Override
    public void rollbackTransaction() {
        try{
            connection.rollback();
            connection.setAutoCommit(true);
            inProcess = false;
            LOGGER.info("Rollback transaction...");
        } catch (SQLException e) {
            LOGGER.error("Error while transaction rollback");
        }
    }

    @Override
    public void close() {
        try {
            if (inProcess) {
                rollbackTransaction();
            }
            connection.close();
            LOGGER.info("Connection has closed");
        } catch (SQLException e) {
            LOGGER.error("Error while connection closing");
        }
    }
}
