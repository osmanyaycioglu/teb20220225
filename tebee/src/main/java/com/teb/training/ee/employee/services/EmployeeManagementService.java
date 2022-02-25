package com.teb.training.ee.employee.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import com.teb.training.ee.employee.data.EmployeeDao;
import com.teb.training.ee.employee.models.Employee;

@LocalBean
@Singleton
public class EmployeeManagementService {

    @EJB
    private EmployeeDao employeeDao;

    public String add(final Employee employeeParam) {
        this.employeeDao.insert(employeeParam);
        return "Added employee id : " + employeeParam.getEmpId();
    }

    public List<Employee> getByName(final String name) {
        return this.employeeDao.getByName(name);
    }

    public List<Employee> getAll() {
        return this.employeeDao.getAll();
    }

    public Employee getById(final Long empId) {
        return this.employeeDao.getById(empId);
    }


}
