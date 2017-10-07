package com.nazar.dao.impl;

import com.nazar.dao.AccountDao;
import com.nazar.dao.MySqlAbstractDao;
import com.nazar.dao.exception.PersistsException;
import com.nazar.dto.Account;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static com.nazar.util.FormatConverter.*;

public class MySqlAccountDao extends MySqlAbstractDao<Account, Long> implements AccountDao {
    private static final Logger LOGGER = Logger.getLogger(MySqlAccountDao.class);
    private static final String SELECT_ALL_QUERY = "SELECT * FROM payment.account;";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM payment.account WHERE a_id = ?;";
    private static final String SELECT_BY_USER_ID = "SELECT a1.* FROM account a1, card c1, user u1\n" +
            "WHERE a1.a_id = c1.a_id AND c1.u_id = ?\n" +
            "GROUP BY a1.a_id;";
    private static final String SELECT_ALL_ACCOUNTS_TO_UNBLOCK =
            "SELECT * FROM account WHERE is_blocked = true AND to_unblock = true;\n";
    private static final String INSERT_SQL =
            "INSERT INTO payment.account(balance, is_blocked, rep_date) VALUES(?, ?, ?);";
    private static final String UPDATE_SQL =
            "UPDATE payment.account SET balance = ?, is_blocked = ?, rep_date = ?, to_unblock = ? WHERE a_id = ?;";
    private static final String DELETE_SQL = "DELETE FROM payment.account WHERE a_id = ?";
    private static final String SELECT_MAX_ID = "SELECT MAX(a_id) FROM payment.account;";

    @Override
    public String getMaxIdQuery() {
        return SELECT_MAX_ID;
    }

    @Override
    public String getSelectByUserIdQuery() {
        return SELECT_BY_USER_ID;
    }

    @Override
    public String getSelectQuery() {
        return SELECT_ALL_QUERY;
    }

    @Override
    public String getSelectByIdQuery() {
        return SELECT_BY_ID_QUERY;
    }

    @Override
    public String getSelectToUnblockQuery() {
        return SELECT_ALL_ACCOUNTS_TO_UNBLOCK;
    }

    @Override
    public String getInsertQuery() {
        return INSERT_SQL;
    }

    @Override
    public String getUpdateQuery() {
        return UPDATE_SQL;
    }

    @Override
    public String getDeleteQuery() {
        return DELETE_SQL;
    }

    public MySqlAccountDao(Connection connection) {
        super(connection);
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement stm, Account item) throws PersistsException {
        try {
            stm.setLong(1, item.getBalance());
            stm.setBoolean(2, item.isBlocked());
            stm.setDate(3, convertCalendarToSqlDate(item.getRepDate()));
        } catch (SQLException e) {
            LOGGER.error("Error while attempting to prepare statement for account inserting");
            throw new PersistsException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement stm, Account item) throws PersistsException {
        try {
            stm.setLong(1, item.getBalance());
            stm.setBoolean(2, item.isBlocked());
            stm.setDate(3, convertCalendarToSqlDate(item.getRepDate()));
            stm.setBoolean(4, item.isToUnblock());
            stm.setLong(5, item.getId());
        } catch (SQLException e) {
            LOGGER.error("Error while attempting to prepare statement for account updating. " + e.getMessage());
            throw new PersistsException(e);
        }
    }

    @Override
    public List<Account> findAllByUserId(Long userId) throws PersistsException {
        try (PreparedStatement stm = connection.prepareStatement(getSelectByUserIdQuery())) {
            stm.setLong(1, userId);
            ResultSet rs = stm.executeQuery();
            return parseResults(rs);
        } catch (SQLException e) {
            LOGGER.error("Error while attempting to find all accounts by user's id. " + e.getMessage());
            throw new PersistsException(e);
        }
    }

    @Override
    public List<Account> findAllToUnblock() throws PersistsException {
        try (PreparedStatement stm = connection.prepareStatement(getSelectToUnblockQuery())) {
            ResultSet rs = stm.executeQuery();
            return parseResults(rs);
        } catch (SQLException e) {
            LOGGER.error("Error while attempting to find all accounts for unblocking. " + e.getMessage());
            throw new PersistsException(e);
        }
    }

    @Override
    public Optional<Account> parseResult(ResultSet rs) throws PersistsException {
        Account result = new Account();
        try {
            result.setId(rs.getLong("a_id"));
            result.setBalance(rs.getLong("balance"));
            result.setBlocked(rs.getBoolean("is_blocked"));
            result.setRepDate(convertSqlDateToCalendar(rs.getDate("rep_date")));
            result.setToUnblock(rs.getBoolean("to_unblock"));
            return Optional.ofNullable(result);
        } catch (SQLException e) {
            LOGGER.error("Error while attempting to parse result into account DAO. " + e.getMessage());
            throw new PersistsException(e);
        }
    }
}