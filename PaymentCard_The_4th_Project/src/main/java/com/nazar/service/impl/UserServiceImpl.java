package com.nazar.service.impl;

import com.nazar.dao.DaoFactory;
import com.nazar.dao.UserDao;
import com.nazar.dao.exception.PersistsException;
import com.nazar.dao.transaction.TransactionManager;
import com.nazar.dao.transaction.TransactionManagerImpl;
import com.nazar.dto.User;
import com.nazar.dto.UserRole;
import com.nazar.service.CardService;
import com.nazar.service.UserService;
import com.nazar.service.exception.UserExistsException;
import com.nazar.service.exception.UserNotExistException;

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.nazar.util.GlobalConst.*;

public class UserServiceImpl implements UserService {
    private DaoFactory daoFactory = DaoFactory.getInstance();

    private UserServiceImpl(){}

    private static class Holder {
        private static final UserServiceImpl INSTANCE = new UserServiceImpl();
    }

    public static UserService getInstance() {
        return Holder.INSTANCE;
    }

    @Override
    public Long createUser(Map<String, String> userDetails) {
        UserDao userDao = daoFactory.getUserDao(daoFactory.getConnection());
        CardService cardService = CardServiceImpl.getInstance();
        try (TransactionManager transaction = new TransactionManagerImpl(daoFactory.getConnection())) {
            String login = userDetails.get(PHONE);
            if(userDao.existLogin(login)){
                throw new UserExistsException();
            }

            User user = new User();
            user.setLogin(login);
            user.setPassword(userDetails.get(PASSWORD));
            user.setFirstName(userDetails.get(FIRST_NAME));
            user.setSurname(userDetails.get(LAST_NAME));
            user.setPatronymic(userDetails.get(PATRONYMIC));
            user.setRegistrationDate(Calendar.getInstance());
            user.setLastVisitDate(Calendar.getInstance());
            user.setRole(UserRole.CLIENT);
            long userId;

            transaction.begin();
            try {
                userId = userDao.insert(user);
            } catch (PersistsException e) {
                transaction.rollbackTransaction();
                throw new UserExistsException(e);
            }
            user.setId(userId);
            cardService.createCardForUser(userId);
            transaction.commit();
            return userId;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getAllUsers() {
        try {
            UserDao userDao = daoFactory.getUserDao(daoFactory.getConnection());
            List<User> users = userDao.findAll();
            return users;
        } catch (PersistsException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public User getUserById(int userId) {
        UserDao userDao = daoFactory.getUserDao(daoFactory.getConnection());
        Optional<User> user;
        try {
            user = userDao.findById(userId);
            if(user.equals(Optional.empty())){
                throw new RuntimeException();
            }
        } catch (PersistsException e) {
            throw new UserNotExistException(e);
        }
        return user.get();
    }

    @Override
    public User login(String login, String password) {
        UserDao userDao = daoFactory.getUserDao(daoFactory.getConnection());
        try {
            Optional<User> user = userDao.findUserByLoginAndPassword(login, password);
            if(user.equals(Optional.empty())){
                throw new RuntimeException();
            }
            return user.get();
        } catch (PersistsException e){
            throw new UserNotExistException(e);
        }
    }

    @Override
    public void updateUser(User user) {
        UserDao userDao = daoFactory.getUserDao(daoFactory.getConnection());
        try {
            userDao.update(user);
        } catch (PersistsException e) {
            throw new UserNotExistException(e);
        }
    }
}
