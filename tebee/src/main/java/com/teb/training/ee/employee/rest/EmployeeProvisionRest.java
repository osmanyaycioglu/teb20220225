package com.teb.training.ee.employee.rest;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.teb.training.ee.rest.models.EmployeeRest;

@Path("/api/v1/employee/provision")
public class EmployeeProvisionRest {

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public EmployeeRest add(@Valid final EmployeeRest employee) {
        //        if (employee.getName() == null) {
        //            throw new IllegalArgumentException("Name null olamaz");
        //        }

        return employee;
    }

    @Path("/activate")
    @GET
    public String activate(@QueryParam("empId") final Long employeeId) {
        return "OK";
    }

    @Path("/suspend")
    @GET
    public String suspend(@QueryParam("empId") final Long employeeId) {
        return "OK";
    }

    @Path("/deactivate")
    @GET
    public String deactivate(@QueryParam("empId") final Long employeeId) {
        return "OK";
    }


}
