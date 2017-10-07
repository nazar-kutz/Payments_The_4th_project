package com.nazar.dto.reports;

public class UnblockedAccountsReport {
    private String info = "";

    public void setInfo(Long accountId) {
        this.info = "SUCCESS! account: " + accountId;
    }

    public void setInfo(Exception e){
        this.info = "ERROR! " + e.toString();
    }

    public String getInfo() {
        return info;
    }
}