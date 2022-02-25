package com.teb.training.ee.employee.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.teb.training.ee.employee.rest.mapper.EmployeeMapper;
import com.teb.training.ee.employee.services.EmployeeManagementService;
import com.teb.training.ee.rest.models.EmployeeRest;

@Path("/api/v1/employee/info")
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeQueryRest {

    @EJB
    private EmployeeManagementService employeeManagementService;

    @Path("/get/single")
    @GET
    public EmployeeRest get(@QueryParam("empId") final Long employeeId) {
        return EmployeeMapper.toEmployeeRest(this.employeeManagementService.getById(employeeId));
    }

    @Path("/get/all")
    @GET
    public List<EmployeeRest> getAll() {
        return EmployeeMapper.toEmployeeRestList(this.employeeManagementService.getAll());
    }

    @Path("/get/by/name")
    @GET
    public List<EmployeeRest> getByName(@QueryParam("name") final String name) {
        return EmployeeMapper.toEmployeeRestList(this.employeeManagementService.getByName(name));

    }

}
