package com.app.commons.beans;

import java.io.Serializable;

public class StatusBean  implements Serializable{
	private static final long serialVersionUID = 1L;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private String code;
	private String message;

}
