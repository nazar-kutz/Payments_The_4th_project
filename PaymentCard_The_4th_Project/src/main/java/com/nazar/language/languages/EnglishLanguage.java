package com.nazar.language.languages;

import static com.nazar.language.StringGlobalConstants.*;

public class EnglishLanguage extends AbstractLanguage {
    private final Object[][] contents = {
            //TITLES
            {TITLE_UNBLOCKING_INFORMATION,  "Unblocking information"},
            {TITLE_LOGIN,                   "Login"},
            {TITLE_REGISTRATION,            "Registration"},
            {TITLE_ACCOUNT,                 "Account"},
            {TITLE_ACCOUNTS_REVIEW,         "my accounts"},
            {TITLE_CARDS_REVIEW,            "my cards"},
            {TITLE_PAYMENT,                 "make a payment"},
            {TITLE_PAYMENT_INFORMATION,     "Information about the last payment"},
            {TITLE_REPLENISH,               "Refill the account"},
            {TITLE_REPLENISH_INFORMATION,   "Information about the last replenishment"},
            {TITLE_LANGUAGE,                "Language"},

            //DATA
            {DATA_PHONE_NUMBER,             "Phone number"},
            {DATA_PASSWORD,                 "Password"},
            {DATA_ID,                       "ID"},
            {DATA_ACCOUNT_BALANCE,          "balance"},
            {DATA_ACCOUNT_REPLENISHMENT_DATE, "Last date of the replenishment"},
            {DATA_FIRST_NAME,               "First name"},
            {DATA_LAST_NAME,                "Last name"},
            {DATA_PATRONYMIC,               "Patronymic"},
            {DATA_REGISTRATION_DATE,        "Registration date"},
            {DATA_YOU_ARE_WELCOME,          ", you are welcome!"},
            {DATA_PERSONAL_INFORMATION,     "Personal information"},
            {DATA_MY_CARDS,                 "My cards"},
            {DATA_MY_ACCOUNTS,              "My accounts"},
            {DATA_EXPIRATION_DATE,          "expiration date"},
            {DATA_ACCOUNT,                  "account"},
            {DATA_RECIPIENT,                "recipient"},
            {DATA_AMOUNT,                   "amount"},
            {DATA_SENDER_ACCOUNT,           "sender account"},
            {DATA_RECIPIENT_ACCOUNT,        "recipient account"},
            {DATA_SUM_OF_REPLENISHMENT,     "sum of the replenishment"},
            {DATA_SUM_OF_PAYMENT,           "sum of the payment"},
            {DATA_DATE,                     "date"},
            {DATA_NOW_YOUR_BALANCE_IS,      "now your balance is"},
            {DATA_IN_PROCESS,               "In the queue for unlocking"},
            {DATA_CHOSE_LANGUAGE,           "Chose the language"},

            //BUTTONS
            {BUTTON_SIGN_IN,                "sign in"},
            {BUTTON_SIGN_UP,                "sign up"},
            {BUTTON_BLOCK,                  "block"},
            {BUTTON_UNBLOCK,                "unblock"},
            {BUTTON_EXIT,                   "EXIT"},
            {BUTTON_SHOW_ACCOUNT,           "go to"},
            {BUTTON_DO_PAYMENT,             "payment"},
            {BUTTON_DO_REPLENISH,           "replenish"},
            {BUTTON_SEND,                   "send"},


            //LINKS
            {LINK_REGISTER_ME,              "register me"},
            {LINK_LOGIN_PAGE,               "login page"},
            {LINK_GO_TO_MY_CARDS,           "MY CARDS"},
            {LINK_GO_TO_MY_ACCOUNTS,        "MY ACCOUNTS"},
            {LINK_GO_TO_CABINET,            "MAIN"},
            {LINK_LANGUAGE,                 "LANGUAGE"},

            //ERRORS
            {ERR_USER_NOT_EXISTS,           "Not correct login or password"},
            {ERR_ACCOUNT_CREATING,          "Can't create an account"},
            {ERR_ACCOUNT_IS_BLOCKED,        "This account is blocked"},
            {ERR_CARD_CREATING,             "Can't create a card"},
            {ERR_NO_SUCH_ACCOUNT,           "No a such account"},
            {ERR_NOT_ENOUGH_MONEY,          "Not enough money"},
            {ERR_USER_EXISTS,               "User with this login already exists"},
            {ERR_NO_ACCESS_TO_ACCOUNT,      "You haven't access to account"},
            {ERR_NO_SUCH_PATH,              "No such path"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
