package com.zhanyun.baseweb.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.Responses;

/**
 * 约定IO错误返回
 * 
 * @author IBM
 *
 */
public class IOWebException extends WebApplicationException {

	private static final long serialVersionUID = 1L;

	public IOWebException() {
		super(Responses.notFound().build());
	}

	public IOWebException(String message) {
		super(Response.status(Responses.NOT_FOUND).entity(message)
				.type("text/plain").build());
	}
}