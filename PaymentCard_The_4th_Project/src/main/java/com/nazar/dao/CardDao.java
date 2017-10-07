package com.nazar.dao;

import com.nazar.dao.exception.PersistsException;
import com.nazar.dto.Card;

import java.sql.SQLException;
import java.util.List;

public interface CardDao extends GenericDao<Card> {
    List<Card> findAllByUserId(Long userId) throws PersistsException;

    String getSelectByUserIdQuery();
}
