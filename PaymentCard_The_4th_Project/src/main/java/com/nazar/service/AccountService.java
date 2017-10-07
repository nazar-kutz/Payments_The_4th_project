package com.nazar.service;

import com.nazar.dto.Account;

import java.util.List;

public interface AccountService {
    Long createAccount();

    boolean doPayment(Account sender, Account recipient, Long amount);

    boolean block(Account account);

    boolean replenish(Account account, Long amount);

    boolean markAccountToUnblock(Account account);

    boolean unblock(Account account);

    Account getAccountById(int accountId);

    List<Account> getAllAccounts();

    List<Account> getAllAccountsToUnblock();

    boolean update(Account account);
}
