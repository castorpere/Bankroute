package com.supinfo.rmt.service;

import com.supinfo.rmt.entity.Employee;
import com.supinfo.rmt.entity.WorkTime;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bargenson
 * Date: 4/30/12
 * Time: 5:54 PM
 */
@Stateless
public class WorkTimeService {

    @PersistenceContext
    private EntityManager em;

    public WorkTime addWorkTime(WorkTime workTime) {
        em.persist(workTime);
        return workTime;
    }

    @SuppressWarnings("unchecked")
    public List<WorkTime> findAllWorkTimesByEmployee(Employee employee) {
        return em.createQuery("SELECT wt FROM WorkTime wt WHERE wt.employee = :employee")
                .setParameter("employee", employee)
                .getResultList();
    }

    public void removeWorkTime(WorkTime workTime) {
        em.remove(em.merge(workTime));
    }
}
