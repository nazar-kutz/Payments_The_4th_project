package com.nazar.dao;

import com.nazar.dao.exception.PersistsException;
import com.nazar.dao.identified.Identified;
import com.nazar.dao.impl.MySqlAccountDao;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class MySqlAbstractDao<T extends Identified<PK>, PK extends Long> implements GenericDao<T> {
    private static final Logger LOGGER = Logger.getLogger(MySqlAbstractDao.class);
    protected Connection connection;

    public abstract String getSelectQuery();
    public abstract String getSelectByIdQuery();
    public abstract String getInsertQuery();
    public abstract String getUpdateQuery();
    public abstract String getDeleteQuery();
    public abstract String getMaxIdQuery();

    protected abstract void prepareStatementForInsert(PreparedStatement stm, T item) throws SQLException, PersistsException;
    protected abstract void prepareStatementForUpdate(PreparedStatement stm, T item) throws SQLException, PersistsException;

    @Override
    public List<T> findAll() throws PersistsException {
        try (PreparedStatement stm = connection.prepareStatement(getSelectQuery())) {
            ResultSet rs = stm.executeQuery();
            return parseResults(rs);
        } catch (SQLException e){
            LOGGER.error("Error while attempting to find all elements. " + e.getMessage());
            throw new PersistsException(e);
        }
    }

    @Override
    public Optional<T> findById(int id) throws PersistsException {
        try (PreparedStatement stm = connection.prepareStatement(getSelectByIdQuery())) {
            stm.setLong(1, id);
            ResultSet rs = stm.executeQuery();
            rs.next();
            return parseResult(rs);
        } catch (SQLException e){
            LOGGER.error("Error while attempting to find an element by its id. " + e.getMessage());
            throw new PersistsException(e);
        }
    }

    @Override
    public boolean update(T item) throws PersistsException {
        try (PreparedStatement stm = connection.prepareStatement(getUpdateQuery())) {
            prepareStatementForUpdate(stm, item);
            int count = stm.executeUpdate();
            if (count > 0){
                return true;
            }
            return false;
        } catch (SQLException e){
            LOGGER.error("Error while attempting to update an element. " + e.getMessage());
            throw new PersistsException(e);
        }
    }

    @Override
    public boolean delete(int id) throws PersistsException {
        try (PreparedStatement stm = connection.prepareStatement(getDeleteQuery())) {
            stm.setLong(1, id);
            int count = stm.executeUpdate();
            if(count > 0){
                return true;
            }
            return false;
        } catch (SQLException e){
            LOGGER.error("Error while attempting to delete an element. " + e.getMessage());
            throw new PersistsException(e);
        }
    }

    @Override
    public Long insert(T item) throws PersistsException {
        try (PreparedStatement stm = connection.prepareStatement(getInsertQuery())) {
            prepareStatementForInsert(stm, item);
            stm.executeUpdate();
            item.setId(getMaxId());
            return item.getId();
        } catch (SQLException e){
            LOGGER.error("Error while attempting to insert an element. " + e.getMessage());
            throw new PersistsException(e);
        }
    }

    @Override
    public Long getMaxId() throws PersistsException {
        try (PreparedStatement stm = connection.prepareStatement(getMaxIdQuery())) {
            ResultSet rs = stm.executeQuery();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e){
            LOGGER.error("Error while attempting to get max id value of the table. " + e.getMessage());
            throw new PersistsException(e);
        }
    }

    protected List<T> parseResults(ResultSet rs) throws PersistsException {
        try {
            List<T> result = new ArrayList<>();
            while (rs.next()){
                result.add(parseResult(rs).get());  //call parseResult(ResultSet rs);
            }
            return result;
        } catch (SQLException e){
            LOGGER.error("Error while attempting to parse results. " + e.getMessage());
            throw new PersistsException(e);
        }
    }

    protected abstract Optional<T> parseResult(ResultSet resultSet) throws PersistsException;

    @Override
    public void close() throws Exception {
        connection.close();
    }

    public MySqlAbstractDao(Connection connection) {
        this.connection = connection;
    }
}
