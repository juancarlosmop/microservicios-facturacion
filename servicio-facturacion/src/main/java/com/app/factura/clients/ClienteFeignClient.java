package com.app.factura.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.app.commons.entity.Cliente;

@FeignClient(name="servicio-cliente")
public interface ClienteFeignClient {
	
	@GetMapping("/getemail/{email}")
	public Cliente getfindByEmail(@PathVariable String email);
}
