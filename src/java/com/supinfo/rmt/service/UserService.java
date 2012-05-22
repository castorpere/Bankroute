package com.supinfo.rmt.service;

import com.supinfo.rmt.entity.User;
import com.supinfo.rmt.exception.AuthenticationException;
import com.supinfo.rmt.exception.UnknownUserException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created with IntelliJ IDEA.
 * User: bargenson
 * Date: 4/26/12
 * Time: 4:05 PM
 */
@Stateless
public class UserService {

    @PersistenceContext
    private EntityManager em;


    public User authenticate(String username, String password) {
        try {
            User user = findUserByUsername(username);
            if(user.getPassword().equals(password)) {
                return user;
            }
        } catch (UnknownUserException e) {/* Pass to the next instruction */ }
        throw new AuthenticationException(username, password);
    }

    public User findUserByUsername(String username) {
        User user = em.find(User.class, username);
        if(user != null) {
            return user;
        }
        throw new UnknownUserException(username);
    }

    public boolean usernameExists(String username) {
        Number nb = (Number) em.createQuery("SELECT COUNT(u) FROM User u WHERE u.username = :username")
                .setParameter("username", username)
                .getSingleResult();

        return nb.intValue() > 0;
    }

}
