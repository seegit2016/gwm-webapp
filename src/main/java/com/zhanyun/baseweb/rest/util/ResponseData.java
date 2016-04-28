package com.zhanyun.baseweb.rest.util;


public class ResponseData<T> {
	private String msg;
	private String msgbox;
	private Boolean success;
	private T data ;
	
	
	public ResponseData(String msg, String msgbox, Boolean success, T data) {
		super();
		this.msg = msg;
		this.msgbox = msgbox;
		this.success = success;
		this.data = data;
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getMsgbox() {
		return msgbox;
	}
	public void setMsgbox(String msgbox) {
		this.msgbox = msgbox;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	} 
	
	
}
