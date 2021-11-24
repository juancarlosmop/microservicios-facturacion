package com.app.item.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoItemController {
	
	@GetMapping("/saludo-item")
	public ResponseEntity<?> obtenerConfig(){
		Map<String, String> json = new HashMap<>();
		json.put("saludo", "hola desde items");
		return new ResponseEntity<Map<String, String>>(json, HttpStatus.OK);
	}
}
