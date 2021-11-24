package com.app.factura.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.commons.beans.ResponseBean;
import com.app.commons.entity.Cliente;
import com.app.commons.entity.Factura;
import com.app.commons.enums.ResponseCodes;
import com.app.factura.clients.ClienteFeignClient;
import com.app.factura.repositoy.FacturaRepository;

@Service
public class FacturaServiceImpl implements IFacturaService{
	
	@Autowired
	private ClienteFeignClient clienteClient;
	
	@Autowired 
	private FacturaRepository facturaDao;
	
	@Override
	public  ResponseBean createFactura(Factura fact,String email) {
		ResponseBean rsp = new ResponseBean();
		Cliente client= clienteClient.getfindByEmail(email);
		if(client!=null) {
			fact.setCliente(client);
			rsp.setDto(facturaDao.save(fact));
			rsp.setStatus(ResponseCodes.SUCCESS);
		}else {
			rsp.setDto(null);
			rsp.setStatus(ResponseCodes.UNKNOW);
			
		}
		return rsp;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Factura findFacturaById(Long id) {
		return facturaDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public void deleteFacturaById(Long id) {
		facturaDao.deleteById(id);
	}
}
