package com.app.commons.beans;

import java.io.Serializable;

import com.app.commons.enums.ResponseCodes;

public class ResponseBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private StatusBean status;
	private Object dto;
	public StatusBean getStatus() {
		return status;
	}
	public void setStatus(ResponseCodes status) {
		this.status = new StatusBean();
		this.status.setCode( status.getCode());
		this.status.setMessage( status.getMessage());
	}
	public Object getDto() {
		return dto;
	}
	public void setDto(Object dto) {
		this.dto = dto;
	}
	
}
