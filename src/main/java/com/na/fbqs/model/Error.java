package com.na.fbqs.model;

public class Error {
	
	private String errCode;
	
	private String errMsg;
	
	public Error(String errorMsg) {
		//TODO add default error code;
		this.errCode = "0";
		this.errMsg = errorMsg;
	}
	
	public Error(String errCode, String errorMsg) {
		//TODO add default error code;
		this.errCode = errCode;
		this.errMsg = errorMsg;
	}

}
