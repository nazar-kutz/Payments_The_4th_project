package com.nazar.dao.impl;

import com.nazar.dao.CardDao;
import com.nazar.dao.MySqlAbstractDao;
import com.nazar.dao.exception.PersistsException;
import com.nazar.dto.Card;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static com.nazar.util.FormatConverter.*;

public class MySqlCardDao extends MySqlAbstractDao<Card, Long> implements CardDao {
    private static final Logger LOGGER = Logger.getLogger(MySqlCardDao.class);
    private static final String SELECT_ALL_QUERY = "SELECT * FROM payment.card;";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM payment.card WHERE c_id = ?;";
    private static final String SELECT_BY_USER_ID_QUERY = "SELECT * FROM payment.card WHERE u_id = ?;";
    private static final String INSERT_SQL =
            "INSERT INTO payment.card(u_id, a_id, expiration_date) VALUES(?, ?, ?);";
    private static final String UPDATE_SQL =
            "UPDATE payment.card SET u_id = ?, a_id = ?, expiration_date = ? WHERE c_id = ?;";
    private static final String DELETE_SQL = "DELETE FROM payment.card WHERE c_id = ?";
    private static final String SELECT_MAX_ID = "SELECT MAX(c_id) FROM payment.card;";

    @Override
    public String getMaxIdQuery() {
        return SELECT_MAX_ID;
    }

    @Override
    public String getSelectByUserIdQuery() {
        return SELECT_BY_USER_ID_QUERY;
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

    public MySqlCardDao(Connection connection) {
        super(connection);
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement stm, Card item) throws PersistsException {
        try {
            stm.setLong(1, item.getUserId());
            stm.setLong(2, item.getAccountId());
            stm.setDate(3, convertCalendarToSqlDate(item.getExpirationDate()));
        } catch (SQLException e) {
            LOGGER.error("Error while attempting to prepare statement for card inserting");
            throw new PersistsException(e);
        }
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement stm, Card item) throws PersistsException {
        try {
            stm.setLong(1, item.getUserId());
            stm.setLong(2, item.getAccountId());
            stm.setDate(3, convertCalendarToSqlDate(item.getExpirationDate()));
            stm.setLong(4, item.getId());
        } catch (SQLException e) {
            LOGGER.error("Error while attempting to prepare statement for card updating");
            throw new PersistsException(e);
        }
    }

    @Override
    public List<Card> findAllByUserId(Long userId) throws PersistsException {
        try (PreparedStatement stm = connection.prepareStatement(getSelectByUserIdQuery())) {
            stm.setLong(1, userId);
            ResultSet rs = stm.executeQuery();
            return parseResults(rs);
        } catch (SQLException e) {
            LOGGER.error("Error while attempting to find all cards by user's id. " + e.getMessage());
            throw new PersistsException(e);
        }
    }

    @Override
    protected Optional<Card> parseResult(ResultSet rs) throws PersistsException {
        try {
            Card card = new Card();
            card.setId(rs.getLong("c_id"));
            card.setUserId(rs.getLong("u_id"));
            card.setAccountId(rs.getLong("a_id"));
            card.setExpirationDate(convertSqlDateToCalendar(rs.getDate("expiration_date")));
            return Optional.ofNullable(card);
        } catch (SQLException e) {
            LOGGER.error("Error while attempting to parse result into card DAO. " + e.getMessage());
            throw new PersistsException(e);
        }
    }
}