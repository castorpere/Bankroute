package com.supinfo.rmt.exception;

import javax.persistence.NoResultException;

/**
 * Created with IntelliJ IDEA.
 * User: bargenson
 * Date: 4/26/12
 * Time: 4:09 PM
 */
public class UnknownUserException extends RuntimeException {

    private String username;

    public UnknownUserException(String username) {
        super("Unknown user with username: " + username);
        this.username = username;
    }

    public UnknownUserException(String username, Exception cause) {
        super("Unknown user with username: " + username, cause);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

}
