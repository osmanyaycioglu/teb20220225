package com.teb.training.ee.ws;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.teb.training.ee.rest.models.EmployeeRest;

@WebService(targetNamespace = "http://training.teb")
public class EmployeeProvisionWS {

    public EmployeeRest add(@WebParam(name = "employee") final EmployeeRest employee) {
        return employee;
    }

    public String activate(@WebParam(name = "employeeId") final Long employeeId) {
        return "OK";
    }

    public String suspend(@WebParam(name = "employeeId") final Long employeeId) {
        return "OK";
    }

    public String deactivate(@WebParam(name = "employeeId") final Long employeeId) {
        return "OK";
    }


}
