package com.klystopad.controller;

import com.klystopad.model.Amount;
import com.klystopad.model.User;
import com.klystopad.service.UserService;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Kirill Listopad on 1/7/16.
 */
@Model
public class UserController {

    @Inject
    private FacesContext facesContext;

    @Inject
    private UserService userService;

    private Amount newAmount;

    @Produces
    @Named
    public Amount getNewAmount() {
        return this.newAmount;
    }

    @Produces
    @Named
    public User getCurrentUser(){
        return userService.getCurrentUser();
    }

    public void receiveCash(){
        try {
            userService.receiveCash(newAmount);
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cashed!", "Cashing successful"));
            initNewAmount();
        } catch (Exception e){
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Cashing unsuccessful");
            facesContext.addMessage(null, m);
        }
    }

    public void logout() throws IOException {
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
        session.invalidate();
        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
        response.sendRedirect("index.jsf");
        facesContext.responseComplete();
    }

    @PostConstruct
    public void initNewAmount(){
        this.newAmount = new Amount();
    }
}
