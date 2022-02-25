package com.teb.training.ee.servlet;

import java.io.IOException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teb.training.ee.security.JWTService;
import com.teb.training.ee.security.UserObj;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

@ApplicationScoped
@WebFilter("/*")
public class MySecurityFilter implements Filter {

    public static final ThreadLocal<UserObj> localUser = new ThreadLocal<>() {

                                                           @Override
                                                           protected UserObj initialValue() {
                                                               return new UserObj();
                                                           }
                                                       };

    @Inject
    private JWTService                       jwtService;

    @Override
    public void doFilter(final ServletRequest requestParam,
                         final ServletResponse responseParam,
                         final FilterChain filterChainParam) throws IOException, ServletException {
        System.out.println("Filter in Progress ----------------- ");
        HttpServletRequest requestLoc = (HttpServletRequest) requestParam;
        HttpServletResponse responseLoc = (HttpServletResponse) responseParam;
        String pathInfoLoc = requestLoc.getPathInfo();
        if (!"/login".equals(pathInfoLoc)) {
            String headerLoc = requestLoc.getHeader("Authorization");
            // Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJvc21hbnkiLCJpYXQiOjE2NDM4ODY2MzIsImV4cCI6MTY0Mzg5MDIzMiwib2lwIjoiMTI3LjAuMC4xIn0.7YnzKqAwFuiQs8GdaWLGBqCwzXIgHVSJjRcn8kxgUeI
            if (headerLoc != null) {
                if (!headerLoc.startsWith("Bearer ")) {
                    this.generateError(responseLoc);
                    return;
                }
                String token = headerLoc.substring(7);
                Jws<Claims> validateLoc = this.jwtService.validate(token);
                if (validateLoc == null) {
                    this.generateError(responseLoc);
                    return;
                }
                Claims bodyLoc = validateLoc.getBody();
                String subjectLoc = bodyLoc.getSubject();
                UserObj userObjLoc = new UserObj();
                userObjLoc.setUsername(subjectLoc);
                userObjLoc.setRole(bodyLoc.get("role",
                                               String.class));
                MySecurityFilter.localUser.set(userObjLoc);

                filterChainParam.doFilter(requestLoc,
                                          responseParam);
            } else {
                this.generateError(responseLoc);
                return;
            }

        } else {
            filterChainParam.doFilter(requestLoc,
                                      responseParam);
        }

    }

    private void generateError(final HttpServletResponse responseLoc) throws IOException {
        responseLoc.setStatus(401);
        responseLoc.getOutputStream()
                   .write("Error while security check".getBytes());
        responseLoc.setHeader("Content-Type",
                              "text/plain");
    }

}
