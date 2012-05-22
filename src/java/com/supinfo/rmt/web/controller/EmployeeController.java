package com.supinfo.rmt.web.controller;

import com.supinfo.rmt.entity.Employee;
import com.supinfo.rmt.entity.Manager;
import com.supinfo.rmt.exception.UsernameAlreadyExistsException;
import com.supinfo.rmt.service.EmployeeService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bargenson
 * Date: 4/26/12
 * Time: 7:32 PM
 */
@ManagedBean
public class EmployeeController {

    @EJB
    private EmployeeService employeeService;

    @ManagedProperty(value = "#{userController}")
    private UserController userController;

    private Employee employee;

    private DataModel<Employee> employeesModel;


    public String addEmployee() {
        if(employee != null) {
            try {
                employee.setManager((Manager) userController.getUser());
                employeeService.addEmployee(employee);
                return "manager_home?faces-redirect=true";
            } catch (UsernameAlreadyExistsException e) {
                FacesUtil.addErrorMessage("Username already exists.", null);
            }
        }
        return null;
    }

    public DataModel<Employee> getEmployeesModel() {
        if(employeesModel == null) {
            List<Employee> employees = employeeService.findEmployeesByManager((Manager) userController.getUser());
            employeesModel = new ListDataModel<Employee>(employees);
        }
        return employeesModel;
    }

    public Employee getEmployee() {
        if(employee == null) {
            employee = new Employee();
        }
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }

    public void validateEmployee(FacesContext context, UIComponent component, Object value) {

    }

}
