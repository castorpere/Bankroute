package com.supinfo.rmt.exception;

import javax.ejb.ApplicationException;

/**
 * Created with IntelliJ IDEA.
 * User: bargenson
 * Date: 4/26/12
 * Time: 4:16 PM
 */
@ApplicationException
public class AuthenticationException extends RuntimeException {

    public AuthenticationException(String username, String password) {
        super("Bad credentials " + username + "/" + password);
    }

}
