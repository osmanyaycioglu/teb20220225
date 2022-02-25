package com.teb.training.ee.security;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/login")
@ApplicationScoped
public class LoginService {

    @Inject
    private JWTService jwtService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String login(final LoginObj loginObjParam) {
        if ("osman".equals(loginObjParam.getUsername()) && "123456".equals(loginObjParam.getPassword())) {
            return this.jwtService.generateJwtToken(loginObjParam.getUsername());
        }
        return "No user";
    }
}
