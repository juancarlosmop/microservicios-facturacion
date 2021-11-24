package com.app.factura.repositoy;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.commons.entity.Factura;

@Repository
public interface FacturaRepository extends CrudRepository<Factura, Long>{

}
