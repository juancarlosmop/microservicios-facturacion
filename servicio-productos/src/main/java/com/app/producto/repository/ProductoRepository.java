package com.app.producto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.commons.entity.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long>{

}
