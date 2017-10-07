package com.nazar.service.impl;

import com.nazar.dao.CardDao;
import com.nazar.dao.DaoFactory;
import com.nazar.dao.transaction.TransactionManager;
import com.nazar.dao.transaction.TransactionManagerImpl;
import com.nazar.dto.Card;
import com.nazar.service.AccountService;
import com.nazar.service.CardService;
import com.nazar.service.exception.CardCreatingException;

import java.util.Calendar;

import static com.nazar.util.GlobalConst.FIVE_YEARS_IN_MILLS;
import static com.nazar.util.FormatConverter.*;

public class CardServiceImpl implements CardService {
    private DaoFactory daoFactory = DaoFactory.getInstance();

    private CardServiceImpl(){}

    private static class Holder {
        private static final CardServiceImpl INSTANCE = new CardServiceImpl();
    }

    public static CardService getInstance() {
        return Holder.INSTANCE;
    }

    @Override
    public void createCardForUser(Long userId) {
        try (TransactionManager manager = new TransactionManagerImpl(daoFactory.getConnection())){
            manager.begin();
            try {
                CardDao cardDao = daoFactory.getCardDao(daoFactory.getConnection());
                Card card = new Card();

                card.setUserId(userId);

                long expirationDateInMills = Calendar.getInstance().getTimeInMillis()+ FIVE_YEARS_IN_MILLS;
                card.setExpirationDate(convertMillsToCalendar(expirationDateInMills));

                AccountService accountService = AccountServiceImpl.getInstance();
                Long accountId = accountService.createAccount();
                card.setAccountId(accountId);

                long cardId = cardDao.insert(card);
                card.setId(cardId);
            } catch (Exception e){
                manager.rollbackTransaction();
                throw new CardCreatingException(e);
            }
            manager.commit();
        } catch (Exception e){
            throw new CardCreatingException(e);
        }
    }
}
