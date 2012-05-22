package com.supinfo.rmt.web.controller;

import com.supinfo.rmt.entity.Client;
import com.supinfo.rmt.service.ClientService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bargenson
 * Date: 4/30/12
 * Time: 5:30 PM
 */
@ManagedBean
public class ClientController {

    @EJB
    private ClientService clientService;

    private Client client;
    private ArrayList<SelectItem> clientItems;

    public String addClient() {
        if(client != null) {
            clientService.addClient(client);
            return "manager_home?faces-redirect=true";
        }
        return null;
    }

    public List<SelectItem> getClientItems() {
        if(clientItems == null) {
            clientItems = new ArrayList<SelectItem>();
            for (Client client : clientService.getAllClients()) {
                clientItems.add(new SelectItem(client, client.getName()));
            }
        }
        return clientItems;
    }

    public Client getClient() {
        if(client == null) {
            client = new Client();
        }
        return client;
    }

}
