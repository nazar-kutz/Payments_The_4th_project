package com.nazar.dto;

import com.nazar.dao.identified.Identified;

import java.util.Calendar;

public class Card implements Identified<Long>{
    private Long id;
    private Long userId;
    private Long accountId;
    private Calendar expirationDate;

    @Override
    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public Calendar getExpirationDate() {
        return expirationDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public void setExpirationDate(Calendar expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", userId=" + userId +
                ", accountId=" + accountId +
                ", expirationDate=" + expirationDate.getTime() +
                '}';
    }
}
