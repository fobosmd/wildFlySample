package com.klystopad.service;

import com.google.common.base.Preconditions;
import com.klystopad.data.BalanceHistoryRepository;
import com.klystopad.model.Amount;
import com.klystopad.model.BalanceHistory;
import com.klystopad.model.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Kirill Listopad on 1/9/16.
 */
@Stateless
public class BalanceHistoryService {

    @Inject
    private Logger log;

    @Inject
    private UserService userService;

    @Inject
    private BalanceHistoryRepository balanceHistoryRepository;

    public List<BalanceHistory> getBalanceHistories(){
        User user = userService.getCurrentUser();
        return balanceHistoryRepository.findByUserName(user.getName());
    }

    public void handleOperation(Amount amount, User user){
        Preconditions.checkNotNull(amount);
        Preconditions.checkNotNull(user);

        BalanceHistory newBalanceHistory = new BalanceHistory();
        newBalanceHistory.setAmount(amount.getAmount());
        newBalanceHistory.setUserName(user.getName());
        newBalanceHistory.setOperationDateTime(LocalDateTime.now());

        balanceHistoryRepository.persist(newBalanceHistory);
        log.info(String.format("Operation history for user [%s] and amount [%s] saved", user.getName(), amount.getAmount()));
    }
}
