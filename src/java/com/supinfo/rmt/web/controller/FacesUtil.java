package com.supinfo.rmt.web.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Created with IntelliJ IDEA.
 * User: bargenson
 * Date: 4/26/12
 * Time: 7:51 PM
 */
public class FacesUtil {

    public static void addErrorMessage(String summary, String details) {
        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, details)
        );
    }

}
