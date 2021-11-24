package com.app.producto.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.app.commons.beans.ResponseBean;
import com.app.commons.entity.Producto;
import com.app.commons.enums.ResponseCodes;
import com.app.producto.service.IProductoService;
@RestController
public class ProductoController {
	
	@Autowired
	private IProductoService productoService;
	
	@PostMapping("/create")
	public ResponseBean createProduct(@RequestBody Producto product) {
		ResponseBean resp = new ResponseBean();
		try {
			productoService.save(product);
			resp.setStatus(ResponseCodes.SUCCESS);
		} catch(DataAccessException e) {
			
		}
		
		return resp;
	}
	
	
	
	@GetMapping("/getbyId/{id}")
	public Producto getfindById(@PathVariable Long id){
		return productoService.findById(id);
	}
	
	@GetMapping("/getall")
	public List<Producto> getAllProducts(){
		return productoService.findAll();
	}
	
	@PutMapping("/update/{id}")
	public ResponseBean updateProduct(@RequestBody Producto product,@PathVariable Long id) {
		ResponseBean resp = new ResponseBean();
		try {
			Producto productoUpdate = productoService.findById(id);
			if(productoUpdate !=null) {
				productoUpdate.setNombre(product.getNombre());
				productoUpdate.setPrecio(product.getPrecio());
				productoUpdate.setCreateAt(product.getCreateAt());
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
	public ResponseBean deleteProduct(@PathVariable Long id) {
		ResponseBean resp = new ResponseBean();
		try {
			productoService.deleteById(id);
			resp.setStatus(ResponseCodes.SUCCESS);
		} catch(DataAccessException e) {
			
		}
		
		return resp;
	}
	
	
}
