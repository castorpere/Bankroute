package com.supinfo.rmt.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bargenson
 * Date: 4/26/12
 * Time: 6:26 PM
 */
@Entity
public class Employee extends User {

    @ManyToOne @JoinColumn
    private Manager manager;

    @OneToMany(mappedBy = "employee")
    private List<WorkTime> workTimes;

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<WorkTime> getWorkTimes() {
        return workTimes;
    }

    public void setWorkTimes(List<WorkTime> workTimes) {
        this.workTimes = workTimes;
    }
}
