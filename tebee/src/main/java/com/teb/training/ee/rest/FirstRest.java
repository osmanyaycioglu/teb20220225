package com.teb.training.ee.rest;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.teb.training.ee.rest.models.EmployeeRest;
import com.teb.training.ee.rest.models.EmployeeX;

// /tebee/rest/first

@Path("/first")
@Produces(MediaType.TEXT_PLAIN)
public class FirstRest {

    // /tebee/rest/first/hello2/XXXXXXXXXXX - GET
    @Path("/hello2/{abc}")
    @GET
    public String hello2(@PathParam("abc") final String name) {
        return "Hello2 " + name;
    }

    // /tebee/rest/first/hello3/XXXXXXXXXXX/sur/YYYYYYYYYYYYYY - GET
    @Path("/hello3/{abc}/sur/{xyz}")
    @GET
    public String hello3(@PathParam("abc") final String name,
                         @PathParam("xyz") final String surname) {
        return "Hello3 " + name + " " + surname;
    }

    // /tebee/rest/first/hello3/XXXXXXXXXXX/sur/YYYYYYYYYYYYYY - GET
    @Path("/hello4/{abc}/sur/{xyz}/{aaa}")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String hello4(@PathParam("abc") final String name,
                         @PathParam("xyz") final String surname,
                         @PathParam("aaa") final Integer age) {
        return "Hello4 " + name + " " + surname + " " + age;
    }

    // /tebee/rest/first/hello5?isim=XXXXXXXX - GET
    @Path("/hello5")
    @GET
    public String hello5(@QueryParam("isim") final String name) {
        return "Hello5 " + name;
    }


    // /tebee/rest/first/hello5?abc=XXXXXXXX&xyz=YYYYYYYY - GET
    @Path("/hello6")
    @GET
    public String hello6(@QueryParam("abc") final String name,
                         @QueryParam("xyz") final String surname) {
        return "Hello6 " + name + " " + surname;
    }

    // /tebee/rest/first/XXXXXXXhello5?xyz=YYYYYYYY - GET
    @Path("/hello7/{isim}")
    @GET
    public String hello7(@PathParam("isim") final String name,
                         @QueryParam("xyz") final String surname) {
        return "Hello7 " + name + " " + surname;
    }

    @Path("/hello8")
    @POST
    @Consumes({
                MediaType.APPLICATION_JSON,
                MediaType.APPLICATION_XML
    })
    @Produces({
                MediaType.APPLICATION_JSON,
                MediaType.APPLICATION_XML
    })
    public EmployeeRest hello8(final EmployeeRest employeeParam) {
        return employeeParam;
    }

    @Path("/hello9")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response hello9(final EmployeeRest employeeParam) {
        return Response.status(Status.ACCEPTED)
                       .header("xyz",
                               "test")
                       .header("X-Forwarded-For",
                               "192.168.1.1")
                       .header("Content-Type",
                               MediaType.TEXT_PLAIN)
                       .entity("Hello9 " + employeeParam)
                       .build();
    }

    @Path("/hello10")
    @GET
    public String hello10(@HeaderParam("abc") final String name,
                          @HeaderParam("xyz") final String surname) {
        return "Hello10 " + name + " " + surname;
    }

    @Path("/hello11")
    @GET
    public String hello11(@BeanParam final EmployeeX employeex) {
        return "Hello 11 : " + employeex;
    }

    // /tebee/rest/first/hello - GET
    @Path("/hello")
    @GET
    public String helloGet() {
        return "Hello world GET";
    }

    // /tebee/rest/first/hello - POST
    @Path("/hello")
    @POST
    public String helloPost() {
        return "Hello world POST";
    }

    // /tebee/rest/first/hello - PUT
    @Path("/hello")
    @PUT
    public String helloPut() {
        return "Hello world PUT";
    }

}
