package com.teb.training.ee.rest;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.teb.training.ee.cdi.Calculator;
import com.teb.training.ee.ejb.MyStatefulEjb;
import com.teb.training.ee.ejb.MyStatelessEjb;

// /tebee/rest/first

@Path("/second")
@Produces(MediaType.TEXT_PLAIN)
@RequestScoped
public class SecondRest implements Serializable {

    @EJB
    // @Inject
    private MyStatelessEjb myStatelessEjb;

    @EJB
    private MyStatefulEjb  myStatefulEjb;

    @Inject
    private Calculator     calculator;

    @Path("/mult/{abc}")
    @GET
    public String mult(@PathParam("abc") final Integer val1) {
        this.myStatelessEjb.mult(val1); // instance 1
        System.out.println("1 Counter : " + this.myStatelessEjb.getCounter());
        System.out.println("1 Counter : " + this.myStatelessEjb.getCounter());
        System.out.println("1 Counter : " + this.myStatelessEjb.getCounter());
        this.myStatelessEjb.mult(val1); // instance 2
        System.out.println("2 Counter : " + this.myStatelessEjb.getCounter());
        System.out.println("2 Counter : " + this.myStatelessEjb.getCounter());
        System.out.println("2 Counter : " + this.myStatelessEjb.getCounter());
        Integer multLoc = this.myStatelessEjb.mult(val1);
        System.out.println("3 Counter : " + this.myStatelessEjb.getCounter());
        System.out.println("3 Counter : " + this.myStatelessEjb.getCounter());
        System.out.println("3 Counter : " + this.myStatelessEjb.getCounter());
        System.out.println("3 Counter : " + this.myStatelessEjb.getCounter());
        return "Result : " + multLoc; // instance 3;
    }

    @Path("/mult2/{abc}")
    @GET
    public String mult2(@PathParam("abc") final Integer val1) {
        this.myStatefulEjb.mult(val1); // instance 1
        System.out.println("1 Counter : " + this.myStatefulEjb.getCounter());
        System.out.println("1 Counter : " + this.myStatefulEjb.getCounter());
        System.out.println("1 Counter : " + this.myStatefulEjb.getCounter());
        this.myStatefulEjb.mult(val1); // instance 2
        System.out.println("2 Counter : " + this.myStatefulEjb.getCounter());
        System.out.println("2 Counter : " + this.myStatefulEjb.getCounter());
        System.out.println("2 Counter : " + this.myStatefulEjb.getCounter());
        Integer multLoc = this.myStatefulEjb.mult(val1);
        System.out.println("3 Counter : " + this.myStatefulEjb.getCounter());
        System.out.println("3 Counter : " + this.myStatefulEjb.getCounter());
        System.out.println("3 Counter : " + this.myStatefulEjb.getCounter());
        System.out.println("3 Counter : " + this.myStatefulEjb.getCounter());
        this.myStatefulEjb.remove();
        return "Result : " + multLoc; // instance 3;
    }

    @Path("/mult3/{abc}")
    @GET
    public String mult3(@PathParam("abc") final Integer val1) {
        Integer multLoc = this.calculator.doubleMult(val1);
        System.out.println("Counter : " + this.calculator.getCounter());
        return "Result : " + multLoc;
    }


    // /tebee/rest/first/hello3/XXXXXXXXXXX/sur/YYYYYYYYYYYYYY - GET
    @Path("/hello3/{abc}/sur/{xyz}")
    @GET
    public String hello3(@PathParam("abc") final String name,
                         @PathParam("xyz") final String surname) {
        return "Hello3 " + name + " " + surname;
    }

}
