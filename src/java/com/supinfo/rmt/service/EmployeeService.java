package com.supinfo.rmt.service;

import com.supinfo.rmt.entity.Employee;
import com.supinfo.rmt.entity.Manager;
import com.supinfo.rmt.entity.User;
import com.supinfo.rmt.exception.UsernameAlreadyExistsException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bargenson
 * Date: 4/26/12
 * Time: 7:33 PM
 */
@Stateless
public class EmployeeService {

    @PersistenceContext
    private EntityManager em;

    @EJB
    private UserService userService;


    public void addEmployee(Employee employee) {
        if(usernameDoesntExist(employee.getUsername())) {
            em.persist(employee);
        } else {
            throw new UsernameAlreadyExistsException(employee.getUsername());
        }
    }

    private boolean usernameDoesntExist(String username) {
        return !userService.usernameExists(username);
    }

    @SuppressWarnings("unchecked")
    public List<Employee> findEmployeesByManager(Manager manager) {
        return em.createQuery("SELECT e FROM Employee e WHERE e.manager = :manager")
                .setParameter("manager", manager)
                .getResultList();
    }
}
