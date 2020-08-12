package com.ezhil.JAX_RS_ExceptionHandler.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.ezhil.JAX_RS_ExceptionHandler.model.ErrorMessage;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exception) {
		ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), 500, "http://exception.com");
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(errorMessage).build();
	}

}
