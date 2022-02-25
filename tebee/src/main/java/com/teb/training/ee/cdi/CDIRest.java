package com.teb.training.ee.cdi;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.teb.training.ee.cdi.interceptor.Caller;
import com.teb.training.ee.cdi.interceptor.CheckRole;
import com.teb.training.ee.cdi.interceptor.DeltaLog;

@Path("/cdi")
public class CDIRest {

    @Inject
    // @Named("hesp")
    @Alternative
    private IHello hello;

    @Inject
    private Caller caller;

    @Path("/hello/{abc}/{xyz}")
    @GET
    @CheckRole("USER")
    public String hello(@PathParam("abc") final String name,
                        @PathParam("xyz") final String surname) {
        return this.hello.hello(name,
                                surname);
    }

    @Path("/greet/{abc}")
    @GET
    @DeltaLog
    @CheckRole("VIEW")
    public String greetXYZ(@PathParam("abc") final String name) {
        return this.caller.greet(name);
    }


}
