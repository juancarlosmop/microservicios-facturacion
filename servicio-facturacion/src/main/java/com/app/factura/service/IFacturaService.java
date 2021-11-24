package com.app.factura.service;

import com.app.commons.beans.ResponseBean;
import com.app.commons.entity.Factura;

public interface IFacturaService {
	public  ResponseBean createFactura(Factura fact,String email);
	public Factura findFacturaById(Long id);
	public void deleteFacturaById(Long id);
}
