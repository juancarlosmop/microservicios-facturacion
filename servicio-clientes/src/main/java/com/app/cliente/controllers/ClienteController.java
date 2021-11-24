package com.app.cliente.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.cliente.services.IClienteService;
import com.app.commons.beans.ResponseBean;
import com.app.commons.entity.Cliente;
import com.app.commons.enums.ResponseCodes;

@RestController
public class ClienteController {
	
	@Autowired
	private IClienteService clienteService;
	
	@PostMapping("/create")
	public ResponseBean createClient(@RequestBody Cliente cliente) {
		ResponseBean resp = new ResponseBean();
		try {
			clienteService.save(cliente);
			resp.setStatus(ResponseCodes.SUCCESS);
		} catch(DataAccessException e) {
			
		}
		
		return resp;
	}
	
	
	
	@GetMapping("/getemail/{email}")
	public Cliente getfindByEmail(@PathVariable String email){
		ResponseBean resp = new ResponseBean();;
		Cliente client=clienteService.findByEmail(email);
		return client;
	}
	
	@GetMapping("/getall")
	public List<Cliente> getAllClients(){
		return clienteService.findAll();
	}
	
	@PutMapping("/update/{id}")
	public ResponseBean updateCliet(@RequestBody Cliente client,@PathVariable Long id) {
		ResponseBean resp = new ResponseBean();
		try {
			Cliente clientUpdate = clienteService.findById( id);
			if(clientUpdate !=null) {
				clientUpdate.setApellido(client.getApellido());
				clientUpdate.setNombre(client.getNombre());
				clientUpdate.setEmail(client.getEmail());
				clientUpdate.setCreateAt(client.getCreateAt());
				clientUpdate.setRegion(client.getRegion());
				clienteService.save(clientUpdate);
				resp.setStatus(ResponseCodes.SUCCESS);
			}else {
				System.out.print("asdf");
			}
			
			
		} catch(DataAccessException e) {
			resp.setStatus(ResponseCodes.ERROR);
		}
		
		return resp;
	}
	
	@PostMapping("/delete/{id}")
	public ResponseBean deleteClient(@PathVariable Long id) {
		ResponseBean resp = new ResponseBean();
		try {
			clienteService.deleteById(id);
			resp.setStatus(ResponseCodes.SUCCESS);
		} catch(DataAccessException e) {
			
		}
		
		return resp;
	}
	

}
