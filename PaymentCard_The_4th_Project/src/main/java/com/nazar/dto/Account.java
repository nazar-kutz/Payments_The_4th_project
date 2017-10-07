package com.nazar.dto;

import com.nazar.dao.identified.Identified;

import java.util.Calendar;

public class Account implements Identified<Long>{
    private Long id;
    private Long balance;
    private boolean isBlocked;
    private Calendar repDate;
    private boolean toUnblock;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public void setRepDate(Calendar repDate) {
        this.repDate = repDate;
    }

    public Long getBalance() {
        return balance;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public Calendar getRepDate() {
        return repDate;
    }

    public void setToUnblock(boolean toUnblock) {
        this.toUnblock = toUnblock;
    }

    public boolean isToUnblock() {
        return toUnblock;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", isBlocked=" + isBlocked +
                ", repDate=" + repDate.getTime() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        return this.getId().equals(account.getId());
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + (repDate != null ? repDate.hashCode() : 0);
        return result;
    }
}
