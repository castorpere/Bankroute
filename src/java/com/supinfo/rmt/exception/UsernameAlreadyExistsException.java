package com.supinfo.rmt.exception;

import javax.ejb.ApplicationException;

/**
 * Created with IntelliJ IDEA.
 * User: bargenson
 * Date: 4/26/12
 * Time: 7:43 PM
 */
@ApplicationException
public class UsernameAlreadyExistsException extends RuntimeException {

    private String username;

    public UsernameAlreadyExistsException(String username) {
        super("Username already exists! Username:" + username);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

}
