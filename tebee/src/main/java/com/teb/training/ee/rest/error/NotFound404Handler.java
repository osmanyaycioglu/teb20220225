package com.teb.training.ee.rest.error;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotFound404Handler implements ExceptionMapper<NotFoundException> {

    @Override
    public Response toResponse(final NotFoundException exp) {
        return Response.status(Status.NOT_FOUND)
                       .header("Content-Type",
                               MediaType.APPLICATION_JSON)
                       .entity(new ErrorObj().setMessage(exp.getMessage())
                                             .setErrorCode(10450))
                       .build();
    }

}
