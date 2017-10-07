package com.nazar.dto.reports;

import java.util.Calendar;

public class PaymentReport {
    private long id;
    private long accountId;
    private long recipient;
    private long amount;
    private Calendar date;

    public PaymentReport(long id, long accountId, long amount, Calendar date, long recipient) {
        this.id = id;
        this.accountId = accountId;
        this.amount = amount;
        this.date = date;
        this.recipient = recipient;
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public static class Builder{
        private Long id = 0L;
        private Long accountId;
        private Long recipient;
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

        public Builder buildRecipient(long recipient){
            this.recipient = recipient;
            return this;
        }

        public PaymentReport build(){
            return new PaymentReport(id, accountId, amount, date, recipient);
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

    public Long getRecipient() {
        return recipient;
    }
}
