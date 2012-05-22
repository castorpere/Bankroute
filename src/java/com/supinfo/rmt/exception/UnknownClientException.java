package com.supinfo.rmt.exception;

import javax.ejb.ApplicationException;

/**
 * Created with IntelliJ IDEA.
 * User: bargenson
 * Date: 4/30/12
 * Time: 6:12 PM
 */
@ApplicationException
public class UnknownClientException extends RuntimeException {

    private Long clientId;

    public UnknownClientException(Long clientId) {
        super("Unknown client with ID:" + clientId);
        this.clientId = clientId;
    }

    public Long getClientId() {
        return clientId;
    }
}
