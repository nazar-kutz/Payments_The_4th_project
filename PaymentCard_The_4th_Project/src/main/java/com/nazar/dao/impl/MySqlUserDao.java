package com.nazar.dao.impl;

import com.nazar.dao.*;
import com.nazar.dao.exception.PersistsException;
import com.nazar.dto.Account;
import com.nazar.dto.Card;
import com.nazar.dto.User;
import com.nazar.dto.UserRole;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static com.nazar.util.FormatConverter.*;

public class MySqlUserDao extends MySqlAbstractDao<User, Long> implements UserDao {
    private static final Logger LOGGER = Logger.getLogger(MySqlUserDao.class);
    private static final String SELECT_ALL_QUERY = "SELECT * FROM payment.user;";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM payment.user WHERE u_id = ?;";
    private static final String SELECT_BY_LOGIN_PASSWORD = "SELECT * FROM payment.user WHERE login = ? AND password = ?;";
    private static final String SELECT_MAX_ID = "SELECT MAX(u_id) FROM payment.user;";
    private static final String EXISTS_LOGIN = "SELECT EXISTS(SELECT * FROM payment.user WHERE login = ?);";
    private static final String INSERT_SQL =
            "INSERT INTO payment.user(first_name, last_name, patronymic, role, login, password, rdate, ldate) "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_SQL =
            "UPDATE payment.user SET first_name = ?, last_name = ?, patronymic = ?, "
                    + "role = ?, login = ?, password = ?, rdate = ?, ldate = ? WHERE u_id = ?;";
    private static final String DELETE_SQL = "DELETE FROM payment.user WHERE u_id = ?";

    @Override
    public String getMaxIdQuery() {
        return SELECT_MAX_ID;
    }

    @Override
    public String getUserLoginPasswordQuery() {
        return SELECT_BY_LOGIN_PASSWORD;
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

    @Override
    public String getUserExistsQuery() {
        return EXISTS_LOGIN;
    }

    public MySqlUserDao(Connection connection) {
        super(connection);
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement stm, User item) throws PersistsException {
        //first_name, last_name, patronymic, role, login, password, rdate, ldate
        try {
            stm.setString(1, item.getFirstName());
            stm.setString(2, item.getSurname());
            stm.setString(3, item.getPatronymic());
            stm.setString(4, item.getRole().name());
            stm.setString(5, item.getLogin());
            stm.setString(6, item.getPassword());
            stm.setDate(7, convertCalendarToSqlDate(item.getRegistrationDate()));
            stm.setDate(8, convertCalendarToSqlDate(item.getLastVisitDate()));
        } catch (SQLException e) {
            LOGGER.error("Error while attempting to prepare statement for user's inserting. " + e.getMessage());
            throw new PersistsException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement stm, User item) throws PersistsException {
        //first_name, last_name, patronymic, role, login, password, rdate, ldate, u_id
        try {
            stm.setString(1, item.getFirstName());
            stm.setString(2, item.getSurname());
            stm.setString(3, item.getPatronymic());
            stm.setString(4, item.getRole().name());
            stm.setString(5, item.getLogin());
            stm.setString(6, item.getPassword());
            stm.setDate(7, convertCalendarToSqlDate(item.getRegistrationDate()));
            stm.setDate(8, convertCalendarToSqlDate(item.getLastVisitDate()));
            stm.setLong(9, item.getId());
        } catch (SQLException e) {
            LOGGER.error("Error while attempting to prepare statement for user's updating. " + e.getMessage());
            throw new PersistsException(e);
        }
    }

    @Override
    public boolean existLogin(String login) throws PersistsException {
        try (PreparedStatement stm = connection.prepareStatement(getUserExistsQuery())) {
            stm.setString(1, login);
            ResultSet rs = stm.executeQuery();
            rs.next();
            return rs.getBoolean(1);
        } catch (Exception e) {
            LOGGER.error("Error while attempting to check login for existing. " + e.getMessage());
            throw new PersistsException(e);
        }
    }

    @Override
    public Optional<User> findUserByLoginAndPassword(String login, String password) throws PersistsException {
        try (PreparedStatement stm = connection.prepareStatement(getUserLoginPasswordQuery())) {
            stm.setString(1, login);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            rs.next();
            return parseResult(rs);
        } catch (Exception e) {
            LOGGER.error("Error while attempting to find an user by login and password. " + e.getMessage());
            throw new PersistsException(e);
        }
    }

    @Override
    protected Optional<User> parseResult(ResultSet rs) throws PersistsException {
        //u_id, first_name, last_name, patronymic, role, login, password, rdate, ldate
        try {
            User user = new User();
            user.setId(rs.getLong("u_id"));
            user.setFirstName(rs.getString("first_name"));
            user.setSurname(rs.getString("last_name"));
            user.setPatronymic(rs.getString("patronymic"));
            user.setRole(UserRole.parseRole(rs.getString("role")));
            user.setLogin(rs.getString("login"));
            user.setPassword(rs.getString("password"));
            user.setRegistrationDate(convertSqlDateToCalendar(rs.getDate("rdate")));
            user.setLastVisitDate(convertSqlDateToCalendar(rs.getDate("ldate")));
            user.setCards(getUserCards(user));
            user.setAccounts(getUserAccounts(user));
            return Optional.ofNullable(user);
        } catch (SQLException e) {
            LOGGER.error("Error while attempting to parse result into user DAO. " + e.getMessage());
            throw new PersistsException(e);
        }
    }

    protected List<Card> getUserCards(User user) throws PersistsException {
        try {
            CardDao cardDao = DaoFactory.getInstance().getCardDao(connection);
            return cardDao.findAllByUserId(user.getId());
        } catch (PersistsException e) {
            LOGGER.error("Error while attempting to get user's cards. " + e.getMessage());
            throw e;
        }
    }

    protected List<Account> getUserAccounts(User user) throws PersistsException {
        try {
            AccountDao accountDao = DaoFactory.getInstance().getAccountDao(connection);
            return accountDao.findAllByUserId(user.getId());
        } catch (PersistsException e) {
            LOGGER.error("Error while attempting to get user's accounts. " + e.getMessage());
            throw e;
        }
    }

}
