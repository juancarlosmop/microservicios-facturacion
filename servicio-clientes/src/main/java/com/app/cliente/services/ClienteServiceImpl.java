package com.app.cliente.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.cliente.repository.ClienteRepository;
import com.app.commons.entity.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService  {

	@Autowired
	private ClienteRepository clienterepository;
	
	@Override
	public List<Cliente> findAll() {
		return (List<Cliente>) clienterepository.findAll();
	}

	@Override
	public Cliente findById(Long id) {
		return clienterepository.findById(id).orElse(null);
	}

	@Override
	public Cliente save(Cliente cliente) {
		return clienterepository.save(cliente);
	}

	@Override
	public void deleteById(Long id) {
		clienterepository.deleteById(id);
		
	}

	@Override
	public Cliente findByEmail(String email) {
		return clienterepository.findyEmail(email);
	}

}
