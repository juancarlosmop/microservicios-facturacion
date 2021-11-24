package com.app.factura.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.commons.beans.ResponseBean;
import com.app.commons.entity.Factura;
import com.app.commons.enums.ResponseCodes;
import com.app.factura.service.IFacturaService;

@RestController
public class FacturaController {
	
	@Autowired
	private IFacturaService factserv;
	
	@PutMapping("/invoice-create/{email}")
	public ResponseBean createinvoice(@RequestBody Factura fact,@PathVariable String email) {
		ResponseBean resp = new ResponseBean();
		try {
			resp= factserv.createFactura(fact, email);
		} catch(DataAccessException e) {
			resp.setStatus(ResponseCodes.ERROR);
		}
		return resp;
	}
	
	@PutMapping("/invoiceitem-create/{email}")
	public ResponseBean updateProduct(@RequestBody Factura fact,@PathVariable String email) {
		ResponseBean resp = new ResponseBean();
		try {
			resp= factserv.createFactura(fact, email);
		} catch(DataAccessException e) {
			resp.setStatus(ResponseCodes.ERROR);
		}
		return resp;
	}
	
	@GetMapping("/invoice-show/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Factura show(@PathVariable Long id) {
		return factserv.findFacturaById(id);
	}
	
	
	@DeleteMapping("/invoice-delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		factserv.deleteFacturaById(id);
	}
}
