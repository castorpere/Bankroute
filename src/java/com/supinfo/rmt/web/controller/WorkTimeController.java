package com.supinfo.rmt.web.controller;

import com.supinfo.rmt.entity.Employee;
import com.supinfo.rmt.entity.WorkTime;
import com.supinfo.rmt.service.WorkTimeService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 * Created with IntelliJ IDEA.
 * User: bargenson
 * Date: 4/30/12
 * Time: 5:51 PM
 */
@ManagedBean
public class WorkTimeController {

    @EJB
    private WorkTimeService workTimeService;

    @ManagedProperty("#{userController}")
    private UserController userController;

    private WorkTime workTime;

    private DataModel<WorkTime> workTimeModel;


    public String addWorkTime() {
        if(workTime != null) {
            Employee employee = (Employee) userController.getUser();
            workTime.setEmployee(employee);
            workTimeService.addWorkTime(workTime);
            return "employee_home?faces-redirect=true";
        }
        return null;
    }

    public WorkTime getWorkTime() {
        if(workTime == null) {
            workTime = new WorkTime();
        }
        return workTime;
    }

    public DataModel<WorkTime> getWorkTimeModel() {
        if(workTimeModel == null) {
            Employee employee = (Employee) userController.getUser();
            workTimeModel = new ListDataModel<WorkTime>(workTimeService.findAllWorkTimesByEmployee(employee));
        }
        return workTimeModel;
    }

    public String removeWorkTime() {
        WorkTime workTimeToRemove = workTimeModel.getRowData();
        workTimeService.removeWorkTime(workTimeToRemove);
        return "employee_home?faces-redirect=true";
    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }

}
