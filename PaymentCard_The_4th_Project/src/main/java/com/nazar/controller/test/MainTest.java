package com.nazar.controller.test;

import com.nazar.dto.User;
import com.nazar.dto.UserRole;
import com.nazar.language.LanguageManager;
import com.nazar.language.languages.AbstractLanguage;
import com.nazar.language.languages.EnglishLanguage;
import com.nazar.language.languages.UkrainianLanguage;
import com.nazar.service.UserService;
import com.nazar.service.impl.UserServiceImpl;

import java.sql.SQLException;

import static com.nazar.language.StringGlobalConstants.TITLE_UNBLOCKING_INFORMATION;

public class MainTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        /*System.out.println("Hello World!!!");
        DaoFactory daoFactory = DaoFactory.getInstance();

        AccountDao accountDao = daoFactory.getAccountDao(daoFactory.getConnection());
        Optional<Account> opAccount = Optional.empty();
        try {
            opAccount = accountDao.findById(10007);
        } catch (PersistsException e){
            System.out.println("ОшиПочка:)");
        }

        if(opAccount.equals(Optional.empty())){
            System.out.println("Кажись пустой:)");
        }
        else {
            System.out.println("Кажись не нул");
            System.out.println(opAccount.get().toString());
        }*/

        /*UserService userService = UserServiceImpl.getInstance();
        User user = userService.login("12", "12345");
        System.out.println(user.toString());

        try {
            Object mysqlDrv =  Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Вдалося!");
            System.out.println(mysqlDrv);
        } catch (Exception ex) {
            ex.printStackTrace();
        }*/

        System.out.println(UserRole.ADMIN.toString());
    }
}
