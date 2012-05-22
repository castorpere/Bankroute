package com.supinfo.rmt.web.controller;

import com.supinfo.rmt.entity.Employee;
import com.supinfo.rmt.entity.Manager;
import com.supinfo.rmt.entity.User;
import com.supinfo.rmt.exception.AuthenticationException;
import com.supinfo.rmt.service.UserService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: bargenson
 * Date: 4/26/12
 * Time: 4:01 PM
 */
@ManagedBean
@SessionScoped
public class UserController implements Serializable {

    @EJB
    private UserService userService;

    private String username;
    private String password;

    private User user;


    public String login() {
        try {
            user = userService.authenticate(username, password);
            if(user instanceof Manager) {
                return "manager_home?faces-redirect=true";
            } else if(user instanceof Employee) {
                return "employee_home?faces-redirect=true";
            }
        } catch (AuthenticationException e) {
            FacesUtil.addErrorMessage("Bad credentials, please try again.", null);
        }
        return null;
    }

    public boolean isAuthenticated() {
        return getUser() != null;
    }

    public String logout() {
        user = null;
        return "login?faces-redirect=true";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
