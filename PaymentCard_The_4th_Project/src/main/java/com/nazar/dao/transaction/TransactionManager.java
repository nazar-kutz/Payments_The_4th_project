package com.nazar.dao.transaction;

public interface TransactionManager extends AutoCloseable{
    void begin();

    void commit();

    void rollbackTransaction();
}
