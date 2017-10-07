package com.nazar.dto;

import com.nazar.dao.identified.Identified;

import java.util.Calendar;
import java.util.List;

public class User implements Identified<Long>{
    private Long id;
    private String firstName;
    private String surname;
    private String patronymic;
    private String login;
    private String password;
    private UserRole role;
    private Calendar registrationDate;
    private Calendar lastVisitDate;
    private List<Card> cards;
    private List<Account> accounts;

    @Override
    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getRole() {
        return role;
    }

    public Calendar getRegistrationDate() {
        return registrationDate;
    }

    public Calendar getLastVisitDate() {
        return lastVisitDate;
    }

    public List<Card> getCards() {
        return cards;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public void setRegistrationDate(Calendar registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setLastVisitDate(Calendar lastVisitDate) {
        this.lastVisitDate = lastVisitDate;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", registrationDate=" + registrationDate.getTime() +
                ", lastVisitDate=" + lastVisitDate.getTime() +
                ", cards=" + cards +
                ", accounts=" + accounts +
                '}';
    }
}