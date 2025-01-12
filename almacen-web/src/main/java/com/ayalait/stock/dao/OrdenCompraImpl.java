package com.ayalait.stock.dao;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.ayalait.stock.modelo.*;



@Repository
public class OrdenCompraImpl implements OrdenCompraDao {

	@Autowired
	OrdenCompraJPASpring daoOrdenCompra;
	
	@Autowired
	DetalleOrdenCompraJPASpring daoDetalleOC;
	
	@Autowired
	OrdenCompraModificaJPASpring daoOCModif;
	
	
	@Override
	public void crearOrdenCompra(OrdenCompra orden) {
		daoOrdenCompra.save(orden);
		
	}

	@Override
	public int obtenerNumeroOrden(String fecha, String idUsuario) {
		// TODO Auto-generated method stub
		return daoOrdenCompra.numeroOrdenCompraADD(idUsuario,fecha);
	}

	@Override
	public OrdenCompra obtenerOrdenCompraPorId(int id) {
		return daoOrdenCompra.findById(id).orElse(null);	}

	@Override
	public void guardarDetalleOrdenCompra(DetalleOrdenCompra detalle) {
		daoDetalleOC.save(detalle);
		
	}

	@Override
	public DetalleOrdenCompra recuperarDetalleOrdenCompraID(int id) {
		return daoDetalleOC.findById(id).orElse(null);

	}

	@Override
	public void eliminarDetalleOrdenCompra(int id) {
		daoDetalleOC.deleteById(id);
		
	}

	@Override
	public void guardarModificacionOC(OrdenCompraModificaciones orden) {
		daoOCModif.save(orden);
		
	}

	
	
	

	

}
