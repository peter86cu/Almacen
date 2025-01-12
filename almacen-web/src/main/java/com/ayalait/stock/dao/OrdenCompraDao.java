package com.ayalait.stock.dao;




import org.springframework.stereotype.Component;

import com.ayalait.stock.modelo.*;





@Component
public interface OrdenCompraDao {
	
	void crearOrdenCompra(OrdenCompra orden);
	int obtenerNumeroOrden(String fecha, String idUsuario);
	OrdenCompra obtenerOrdenCompraPorId(int id);
	void guardarDetalleOrdenCompra(DetalleOrdenCompra detalle);
	DetalleOrdenCompra recuperarDetalleOrdenCompraID(int id);
	void eliminarDetalleOrdenCompra(int id);
	void guardarModificacionOC(OrdenCompraModificaciones orden);
	
	

}
