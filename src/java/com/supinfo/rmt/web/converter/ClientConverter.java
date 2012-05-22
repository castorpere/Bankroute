package com.supinfo.rmt.web.converter;

import com.supinfo.rmt.entity.Client;
import com.supinfo.rmt.service.ClientService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Created with IntelliJ IDEA.
 * User: bargenson
 * Date: 4/30/12
 * Time: 6:08 PM
 */
@ManagedBean
public class ClientConverter implements Converter {

    @EJB
    private ClientService clientService;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        Long clientId = Long.valueOf(s);
        return clientService.findClientById(clientId);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        Client client = (Client) o;
        return String.valueOf(client.getId());
    }

}
