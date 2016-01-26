package com.klystopad.service;

import com.google.common.base.Preconditions;
import com.klystopad.data.UserRepository;
import com.klystopad.model.Amount;
import com.klystopad.model.User;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.logging.Logger;

/**
 * Created by Kirill Listopad on 1/7/16.
 */
@Stateless
public class UserService {

    @Resource
    private SessionContext sessionContext;

    @Inject
    private Logger log;

    @Inject
    private UserRepository userRepository;

    @Inject
    private BalanceHistoryService balanceHistoryService;

    public void receiveCash(Amount amount){
        Preconditions.checkNotNull(amount);
//        Preconditions.checkNotNull(user);

        User user = getCurrentUser();

        Preconditions.checkState(user.getBalance().compareTo(amount.getAmount()) != -1);

        user.setBalance(user.getBalance().subtract(amount.getAmount()));
        userRepository.persist(user);
        balanceHistoryService.handleOperation(amount, user);
        log.info(String.format("User [%s] got [%s] of cash, left [%s]", user.getName(), amount.getAmount(), user.getBalance()));
    }

    public User getCurrentUser(){
        String userName = sessionContext.getCallerPrincipal().getName();
        return userRepository.findByName(userName);
    }
}
