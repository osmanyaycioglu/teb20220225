package com.teb.training.ee.employee.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.teb.training.ee.rest.models.EmployeeRest;

@Path("/api/v1/employee/management")
public class EmployeeManagementRest {

    @Path("/update")
    @POST
    public String update(final EmployeeRest employee) {
        return "OK";
    }

}
