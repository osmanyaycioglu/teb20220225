package com.teb.training.ee.employee.rest.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.teb.training.ee.employee.models.Employee;
import com.teb.training.ee.employee.models.EmployeeCredential;
import com.teb.training.ee.rest.models.EmployeeRest;

public class EmployeeMapper {

    public static Employee toEmloyee(final EmployeeRest employeeParam) {
        Employee employeeLoc = new Employee();
        employeeLoc.setName(employeeParam.getName());
        employeeLoc.setSurname(employeeParam.getSurname());
        employeeLoc.setHeight(employeeParam.getHeight());
        employeeLoc.setWeight(employeeParam.getWeight());
        employeeLoc.setGender(employeeParam.getGender());
        EmployeeCredential credentialLoc = new EmployeeCredential();
        credentialLoc.setUsername(employeeParam.getUsername());
        credentialLoc.setPassword(employeeParam.getPassword());
        credentialLoc.setEmployee(employeeLoc);
        employeeLoc.setEmployeeCredential(credentialLoc);
        employeeLoc.setPhones(employeeParam.getPhones());
        return employeeLoc;
    }

    public static EmployeeRest toEmployeeRest(final Employee employeeParam) {
        EmployeeRest employeeLoc = new EmployeeRest();
        employeeLoc.setName(employeeParam.getName());
        employeeLoc.setSurname(employeeParam.getSurname());
        employeeLoc.setHeight(employeeParam.getHeight());
        employeeLoc.setWeight(employeeParam.getWeight());
        employeeLoc.setGender(employeeParam.getGender());
        employeeLoc.setUsername(employeeParam.getEmployeeCredential()
                                             .getUsername());
        employeeLoc.setPhones(employeeParam.getPhones());
        return employeeLoc;
    }

    public static List<EmployeeRest> toEmployeeRestList(final List<Employee> allParam) {
        return allParam.stream()
                       .map(e -> toEmployeeRest(e))
                       .collect(Collectors.toList());
    }

}
