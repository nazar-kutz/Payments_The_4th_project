package com.nazar.language.languages;

import static com.nazar.language.StringGlobalConstants.*;

public class UkrainianLanguage extends AbstractLanguage {
    private final Object[][] contents = {
            //TITLES
            {TITLE_UNBLOCKING_INFORMATION,  "Інформація по розблокуванню"},
            {TITLE_LOGIN,                   "Вхід"},
            {TITLE_REGISTRATION,            "Реєстрація"},
            {TITLE_ACCOUNT,                 "Рахунок"},
            {TITLE_ACCOUNTS_REVIEW,         "мої рахунки"},
            {TITLE_CARDS_REVIEW,            "мої картки"},
            {TITLE_PAYMENT,                 "Зробити платіж"},
            {TITLE_PAYMENT_INFORMATION,     "Інформація з останнього платежу"},
            {TITLE_REPLENISH,               "Поповнити рахунок"},
            {TITLE_REPLENISH_INFORMATION,   "Інформація з останнього поповнення"},
            {TITLE_LANGUAGE,                "Мова"},

            //DATA
            {DATA_PHONE_NUMBER,             "Номер телефону"},
            {DATA_PASSWORD,                 "Пароль"},
            {DATA_ID,                       "ID"},
            {DATA_ACCOUNT_BALANCE,          "баланс"},
            {DATA_ACCOUNT_REPLENISHMENT_DATE, "Дата останнього поповнення"},
            {DATA_FIRST_NAME,               "Ім'я"},
            {DATA_LAST_NAME,                "Прізвище"},
            {DATA_PATRONYMIC,               "По батькові"},
            {DATA_REGISTRATION_DATE,        "Дата реєстрації"},
            {DATA_YOU_ARE_WELCOME,          ", ласкаво просимо!"},
            {DATA_PERSONAL_INFORMATION,     "Персональні дані"},
            {DATA_MY_CARDS,                 "Мої картки"},
            {DATA_MY_ACCOUNTS,              "Мої рахунки"},
            {DATA_EXPIRATION_DATE,          "Дата завершення дії картки"},
            {DATA_ACCOUNT,                  "рахунок"},
            {DATA_RECIPIENT,                "отримувач"},
            {DATA_AMOUNT,                   "сума"},
            {DATA_SENDER_ACCOUNT,           "рахунок відправника"},
            {DATA_RECIPIENT_ACCOUNT,        "рахунок отримувача"},
            {DATA_SUM_OF_REPLENISHMENT,     "сума поповнення"},
            {DATA_SUM_OF_PAYMENT,           "сума платежу"},
            {DATA_DATE,                     "дата"},
            {DATA_NOW_YOUR_BALANCE_IS,      "тепер ваш баланс становить"},
            {DATA_IN_PROCESS,               "В черзі на розблокування"},
            {DATA_CHOSE_LANGUAGE,           "Виберіть мову"},

            //BUTTONS
            {BUTTON_SIGN_IN,                "увійти"},
            {BUTTON_SIGN_UP,                "зареєструватися"},
            {BUTTON_BLOCK,                  "заблокувати"},
            {BUTTON_UNBLOCK,                "розблокувати"},
            {BUTTON_EXIT,                   "ВИХІД"},
            {BUTTON_SHOW_ACCOUNT,           "перейти"},
            {BUTTON_DO_PAYMENT,             "зробити платіж"},
            {BUTTON_DO_REPLENISH,           "поповнити"},
            {BUTTON_SEND,                   "відправити"},

            //LINKS
            {LINK_REGISTER_ME,              "зареєструватися"},
            {LINK_LOGIN_PAGE,               "увійти"},
            {LINK_GO_TO_MY_CARDS,           "МОЇ КАРТКИ"},
            {LINK_GO_TO_MY_ACCOUNTS,        "МОЇ РАХУНКИ"},
            {LINK_GO_TO_CABINET,            "ГОЛОВНА"},
            {LINK_LANGUAGE,                 "МОВА"},

            //ERRORS
            {ERR_USER_NOT_EXISTS,           "Не коректний логін або пароль"},
            {ERR_ACCOUNT_CREATING,          "Не вдається створити рахунок"},
            {ERR_ACCOUNT_IS_BLOCKED,        "Цей рахунок заблоковано"},
            {ERR_CARD_CREATING,             "Не вдається створити картки"},
            {ERR_NO_SUCH_ACCOUNT,           "Такого рахунку не існує"},
            {ERR_NOT_ENOUGH_MONEY,          "Не достатньо грошей"},
            {ERR_USER_EXISTS,               "Користувач з таким логіном уже існує"},
            {ERR_NO_ACCESS_TO_ACCOUNT,      "Ви не маєте доступу до цього рахунку"},
            {ERR_NO_SUCH_PATH,              "Немає такого шляху"}
    };

    @Override
    protected Object[][] getContents() {
        return contents;
    }
}
