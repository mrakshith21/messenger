package javabrains.messenger.exceptions;

import javax.swing.text.html.parser.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import javabrains.messenger.model.ErrorMessage;


public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable exception) {
		ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), 500, "http://www.wikipedia.org");
		return Response.status(Status.NOT_FOUND)
				.entity(errorMessage).
				build();
	}

}
