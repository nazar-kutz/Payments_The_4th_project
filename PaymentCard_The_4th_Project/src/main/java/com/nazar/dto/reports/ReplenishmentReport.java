package com.nazar.dto.reports;

import java.util.Calendar;

public class ReplenishmentReport {
    private long id;
    private long accountId;
    private long amount;
    private Calendar date;

    public ReplenishmentReport(long id, long accountId, long amount, Calendar date) {
        this.id = id;
        this.accountId = accountId;
        this.amount = amount;
        this.date = date;
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public static class Builder{
        private Long id = 0L;
        private Long accountId;
        private Long amount;
        private Calendar date;

        public Builder buildId(long id){
            this.id = id;
            return this;
        }

        public Builder buildAccountId(long id){
            this.accountId = id;
            return this;
        }

        public Builder buildAmount(long amount){
            this.amount = amount;
            return this;
        }

        public Builder buildDate(Calendar date){
            this.date = date;
            return this;
        }

        public ReplenishmentReport build(){
            return new ReplenishmentReport(id, accountId, amount, date);
        }
    }

    public Long getId() {
        return id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public Long getAmount() {
        return amount;
    }

    public Calendar getDate() {
        return date;
    }
}
