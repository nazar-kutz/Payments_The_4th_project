package com.nazar.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PathManager {
    private String loginUri;
    private String registrationUri;
    private String adminCabinetUri;
    private String adminUnblockingInfoUri;
    private String userCabinetUri;
    private String userAccountReviewUri;
    private String userAccountPageUri;
    private String userCardReviewUri;
    private String userReplenishUri;
    private String userReplenishInfoUri;
    private String userPaymentUri;
    private String userPaymentInfoUri;
    private String commonLanguageUri;

    private String loginCommandPath;
    private String registrationCommandPath;
    private String exitCommandPath;
    private String replenishCommandPath;
    private String paymentCommandPath;
    private String transitionCommandPath;
    private String blockAccountCommandPath;
    private String unblockRequestCommandPath;
    private String unblockAccountCommandPath;
    private String languageCommandPath;

    private PathManager() {
        load();
    }

    private static class Holder {
        private static PathManager INSTANCE = new PathManager();
    }

    public static PathManager getInstance(){
        return Holder.INSTANCE;
    }

    private void load(){
        try( InputStream in = this.getClass().getResourceAsStream("/pg.properties")){
            Properties properties = new Properties();
            properties.load(in);
            loginUri = properties.getProperty("page.login");
            registrationUri = properties.getProperty("page.register");
            adminCabinetUri = properties.getProperty("page.admin.cabinet");
            adminUnblockingInfoUri = properties.getProperty("page.admin.unblocking.info");
            userCabinetUri = properties.getProperty("page.user.cabinet");
            userAccountReviewUri = properties.getProperty("page.user.accounts.review");
            userAccountPageUri = properties.getProperty("page.user.account");
            userCardReviewUri = properties.getProperty("page.user.cards.review");
            userReplenishUri = properties.getProperty("page.user.replenish.process");
            userReplenishInfoUri = properties.getProperty("page.user.replenish.info");
            userPaymentUri = properties.getProperty("page.user.payment.process");
            userPaymentInfoUri = properties.getProperty("page.user.payment.info");
            commonLanguageUri = properties.getProperty("page.common.language");

            loginCommandPath = properties.getProperty("path.login.command");
            registrationCommandPath = properties.getProperty("path.register.command");
            exitCommandPath = properties.getProperty("path.exit.command");
            replenishCommandPath = properties.getProperty("path.replenish.command");
            paymentCommandPath = properties.getProperty("path.payment.command");
            transitionCommandPath = properties.getProperty("path.transition.command");
            blockAccountCommandPath = properties.getProperty("path.block.account.command");
            unblockAccountCommandPath = properties.getProperty("path.unblock.account.command");
            unblockRequestCommandPath = properties.getProperty("path.unblock.request.command");
            languageCommandPath = properties.getProperty("path.language.command");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getLoginUri() {
        return loginUri;
    }

    public String getRegistrationUri() {
        return registrationUri;
    }

    public String getAdminCabinetUri() {
        return adminCabinetUri;
    }

    public String getAdminUnblockingInfoUri() {
        return adminUnblockingInfoUri;
    }

    public String getUserCabinetUri() {
        return userCabinetUri;
    }

    public String getUserAccountReviewUri() {
        return userAccountReviewUri;
    }

    public String getUserAccountPageUri() {
        return userAccountPageUri;
    }

    public String getUserCardReviewUri() {
        return userCardReviewUri;
    }

    public String getUserReplenishUri() {
        return userReplenishUri;
    }

    public String getUserReplenishInfoUri() {
        return userReplenishInfoUri;
    }

    public String getUserPaymentUri() {
        return userPaymentUri;
    }

    public String getUserPaymentInfoUri() {
        return userPaymentInfoUri;
    }

    public String getLoginCommandPath() {
        return loginCommandPath;
    }

    public String getRegistrationCommandPath() {
        return registrationCommandPath;
    }

    public String getExitCommandPath() {
        return exitCommandPath;
    }

    public String getReplenishCommandPath() {
        return replenishCommandPath;
    }

    public String getPaymentCommandPath() {
        return paymentCommandPath;
    }

    public String getTransitionCommandPath() {
        return transitionCommandPath;
    }

    public String getBlockAccountCommandPath() {
        return blockAccountCommandPath;
    }

    public String getUnblockRequestCommandPath() {
        return unblockRequestCommandPath;
    }

    public String getUnblockAccountCommandPath() {
        return unblockAccountCommandPath;
    }

    public String getLanguageCommandPath() {
        return languageCommandPath;
    }

    public String getCommonLanguageUri() {
        return commonLanguageUri;
    }
}

