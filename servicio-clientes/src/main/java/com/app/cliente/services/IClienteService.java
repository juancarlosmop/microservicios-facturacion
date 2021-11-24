package com.app.cliente.services;

import java.util.List;

import com.app.commons.entity.Cliente;

public interface IClienteService {
	public List<Cliente> findAll();
	public Cliente findById(Long id);
	public Cliente findByEmail(String email);
	public Cliente save(Cliente cliente);
	public void deleteById(Long id);
}

