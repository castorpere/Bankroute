package com.supinfo.rmt.service;

import com.supinfo.rmt.entity.Client;
import com.supinfo.rmt.exception.UnknownClientException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bargenson
 * Date: 4/30/12
 * Time: 5:34 PM
 */
@Stateless
public class ClientService {

    @PersistenceContext
    private EntityManager em;

    public Client addClient(Client client) {
        em.persist(client);
        return client;
    }

    @SuppressWarnings("unchecked")
    public List<Client> getAllClients() {
        return em.createQuery("SELECT c FROM Client c").getResultList();
    }

    public Client findClientById(Long clientId) {
        Client client = em.find(Client.class, clientId);
        if(client == null) throw new UnknownClientException(clientId);
        return client;
    }
}
