package com.klystopad.controller;

import com.klystopad.model.BalanceHistory;
import com.klystopad.service.BalanceHistoryService;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by Kirill Listopad on 1/9/16.
 */
@Model
public class BalanceHistoryController {

    @Inject
    private FacesContext facesContext;

    @Inject
    private BalanceHistoryService balanceHistoryService;

    private List<BalanceHistory> balanceHistories;

    @Produces
    @Named
    public List<BalanceHistory> getBalanceHistories(){
        return balanceHistories;
    }

    @PostConstruct
    public void init(){
        balanceHistories = balanceHistoryService.getBalanceHistories();
    }
}
