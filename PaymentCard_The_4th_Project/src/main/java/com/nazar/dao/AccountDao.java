package com.nazar.dao;

import com.nazar.dao.exception.PersistsException;
import com.nazar.dto.Account;

import java.sql.SQLException;
import java.util.List;

public interface AccountDao extends GenericDao<Account> {
    String getSelectToUnblockQuery();

    List<Account> findAllByUserId(Long userId) throws PersistsException;

    String getSelectByUserIdQuery();

    List<Account> findAllToUnblock() throws PersistsException;
}
