package com.zhanyun.baseweb.exception;


public class OtherWebException extends BaseWebException {
 
	private static final long serialVersionUID = 1L;
  
	public OtherWebException(String message, int status) {
		super(message,status);
	}
}