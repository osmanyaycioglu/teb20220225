package com.teb.training.ee.rest.error;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ExceptionHandler implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(final Exception exp) {
        exp.printStackTrace();
        return Response.status(Status.INTERNAL_SERVER_ERROR)
                       .header("Content-Type",
                               MediaType.APPLICATION_JSON)
                       .entity(new ErrorObj().setMessage(exp.getMessage())
                                             .setErrorCode(20005))
                       .build();
    }

}
