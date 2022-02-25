package com.teb.training.ee.employee.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.teb.training.ee.rest.models.EmployeeRest;

@Path("/api/v1/employee/info")
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeQueryRest {

    @Path("/get/single")
    @GET
    public EmployeeRest get(@QueryParam("empId") final Long employeeId) {
        return null;
    }

    @Path("/get/all")
    @GET
    public List<EmployeeRest> getAll() {
        return null;
    }

    @Path("/get/by/name")
    @GET
    public List<EmployeeRest> getAll(@QueryParam("name") final String name) {
        return null;
    }

}
