package com.nazar.dao;

import com.nazar.dao.exception.PersistsException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface GenericDao<T> extends AutoCloseable {
    List<T> findAll() throws PersistsException;
    Optional<T> findById(int id) throws PersistsException;
    boolean update(T item) throws PersistsException;
    boolean delete(int id) throws PersistsException;
    Long insert(T item) throws PersistsException;
    Long getMaxId() throws PersistsException;
}
