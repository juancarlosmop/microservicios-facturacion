package com.app.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.commons.entity.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	@Query("select  c  from Cliente c where c.email =?1 ")
	public Cliente findyEmail(String email);
}
