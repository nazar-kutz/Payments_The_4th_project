package com.nazar.service.impl;

import com.nazar.dao.AccountDao;
import com.nazar.dao.DaoFactory;
import com.nazar.dao.exception.PersistsException;
import com.nazar.dao.transaction.TransactionManager;
import com.nazar.dao.transaction.TransactionManagerImpl;
import com.nazar.dto.Account;
import com.nazar.service.AccountService;
import com.nazar.service.exception.AccountCreatingException;
import com.nazar.service.exception.AccountIsBlockedException;
import com.nazar.service.exception.NoSuchAccountException;
import com.nazar.service.exception.NotEnoughMoneyException;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

public class AccountServiceImpl implements AccountService {
    private DaoFactory daoFactory = DaoFactory.getInstance();

    private AccountServiceImpl(){}

    private static class Holder {
        private static final AccountServiceImpl INSTANCE = new AccountServiceImpl();
    }

    public static AccountService getInstance() {
        return Holder.INSTANCE;
    }

    @Override
    public Long createAccount() {
        AccountDao accountDao = daoFactory.getAccountDao(daoFactory.getConnection());
        Account account = new Account();
        try (TransactionManager manager = new TransactionManagerImpl(daoFactory.getConnection())) {
            account.setBalance(1L);
            account.setBlocked(false);
            account.setRepDate(Calendar.getInstance());

            long accountId = 0;
            manager.begin();
            try {
                accountId = accountDao.insert(account);
            } catch (PersistsException e){
                manager.rollbackTransaction();
            }

            account.setId(accountId);
            manager.commit();
            return accountId;
        } catch (Exception e) {
            throw new AccountCreatingException(e);
        }
    }

    @Override
    public boolean doPayment(Account sender, Account recipient, Long amount) {
        try (TransactionManager manager = new TransactionManagerImpl(daoFactory.getConnection())){
            if(amount <= 0){
                throw new IllegalArgumentException("not correct amount of money: " + amount);
            }
            if(amount > sender.getBalance()){
                throw new NotEnoughMoneyException(sender.getBalance(), amount);
            }
            if(sender.isBlocked() || recipient.isBlocked()){
                throw new AccountIsBlockedException();
            }

            manager.begin();
            try{
                sender.setBalance(sender.getBalance() - amount);
                update(sender);
                recipient.setBalance(recipient.getBalance() + amount);
                update(recipient);
            } catch (Exception e){
                manager.rollbackTransaction();
                return false;
            }
            manager.commit();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean block(Account account) {
        account.setBlocked(true);
        if(update(account)){
            return true;
        }
        return false;
    }

    @Override
    public boolean replenish(Account account, Long amount) {
        if(amount <= 0){
            throw new IllegalArgumentException("Not correct amount of money for replenishment: " + amount);
        }
        if(account.isBlocked() == true){
            throw new AccountIsBlockedException();
        }
        Long result = account.getBalance() + amount;
        account.setBalance(result);
        AccountDao accountDao = daoFactory.getAccountDao(daoFactory.getConnection());
        try {
            boolean operationSuccess = accountDao.update(account);
            return operationSuccess;
        } catch (Exception e){
            throw new NoSuchAccountException(e);
        }
    }

    @Override
    public boolean markAccountToUnblock(Account account){
        if(account.isToUnblock() == true || account.isBlocked() == false){
            return false;
        }
        account.setToUnblock(true);
        update(account);
        return true;
    }

    @Override
    public boolean unblock(Account account) {
        account.setBlocked(false);
        account.setToUnblock(false);
        if(update(account)){
            return true;
        }
        return false;
    }

    @Override
    public Account getAccountById(int accountId) {
        AccountDao accountDao = daoFactory.getAccountDao(daoFactory.getConnection());
        Optional<Account> account;
        try {
            account = accountDao.findById(accountId);
            if(account.equals(Optional.empty())){
                throw new RuntimeException();
            }
        } catch (Exception e) {
            throw new NoSuchAccountException(accountId);
        }
        return account.get();
    }

    @Override
    public List<Account> getAllAccounts(){
        AccountDao accountDao = daoFactory.getAccountDao(daoFactory.getConnection());
        try {
            List<Account> accounts = accountDao.findAll();
            return accounts;
        } catch (PersistsException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Account> getAllAccountsToUnblock(){
        AccountDao accountDao = daoFactory.getAccountDao(daoFactory.getConnection());
        try {
            List<Account> accounts = accountDao.findAllToUnblock();
            return accounts;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Account account) {
        AccountDao accountDao = daoFactory.getAccountDao(daoFactory.getConnection());
        try {
            accountDao.update(account);
            return true;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
