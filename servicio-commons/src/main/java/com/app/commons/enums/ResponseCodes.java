package com.app.commons.enums;

import java.io.Serializable;

public enum ResponseCodes implements Serializable {
	SUCCESS("OK","EXITO"),
	AUTH("AUTH","Usuario o contraseña no validos"),
	EXISTDATA("EXISTDATA","El registro no existe"),
	EMAILEXIST("EXISTREGISTER","Ya existe un usuario que registro este correo"),
	ERROR("ERROR","Algo ucurrio durante la ejecucion"),
	UNKNOW("UNKNOW","El dato no fue encontrado");
	private final String message;
	private final String code;
	private ResponseCodes(String code, String message) {
		this.code = code;
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	
}
