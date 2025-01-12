package com.ayalait.stock.dao;




import org.springframework.stereotype.Component;

import com.ayalait.stock.modelo.*;




@Component
public interface FacturasCompraDao {
	
	void crearFacturaCompra(FacturaCompra factura);
	int obtenerNumeroFactura(String fecha, String idUsuario);
	FacturaCompra obtenerFacturaCompraPorId(int id);
	void guardarDetalleFactura(DetalleFacturaCompra detalle);
	DetalleFacturaCompra recuperarDetalleFactura(int id);
	
	

}
