package com.zhanyun.baseweb.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class BaseWebException extends WebApplicationException{
	private static final long serialVersionUID = 1L;
	
	public BaseWebException(String message, int status) {
		super(Response.status(status).entity("{\"error\":\""+message+"\"}").type("application/json")
				.build());
	}

}
