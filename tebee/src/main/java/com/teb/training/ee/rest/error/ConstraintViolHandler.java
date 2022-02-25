package com.teb.training.ee.rest.error;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ConstraintViolHandler implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(final ConstraintViolationException exp) {
        ErrorObj root = new ErrorObj().setMessage("Validasyon Errorü")
                                      .setErrorCode(10450);
        Set<ConstraintViolation<?>> constraintViolationsLoc = exp.getConstraintViolations();
        for (ConstraintViolation<?> constraintViolationLoc : constraintViolationsLoc) {
            root.addSubError(new ErrorObj().setMessage(constraintViolationLoc.toString())
                                           .setErrorCode(10451));
        }
        return Response.status(Status.BAD_REQUEST)
                       .header("Content-Type",
                               MediaType.APPLICATION_JSON)
                       .entity(root)
                       .build();
    }

}
