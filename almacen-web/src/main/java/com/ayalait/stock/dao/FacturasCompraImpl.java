package com.ayalait.stock.dao;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.ayalait.stock.modelo.*;



@Repository
public class FacturasCompraImpl implements FacturasCompraDao {

	
	@Autowired
	FacturaCompraJPASpring daoFactura;
	
	@Autowired
	DetalleFacturaCompraJPASpring daoDetalleFC;

	@Override
	public void crearFacturaCompra(FacturaCompra factura) {
		daoFactura.save(factura);
		
	}

	@Override
	public int obtenerNumeroFactura(String fecha, String idUsuario) {
		return daoFactura.numeroFacturaCompraADD(idUsuario,fecha);
	}

	@Override
	public FacturaCompra obtenerFacturaCompraPorId(int id) {
		return daoFactura.findById(id).orElse(null);
	}

	@Override
	public void guardarDetalleFactura(DetalleFacturaCompra detalle) {
		daoDetalleFC.save(detalle);
		
	}

	@Override
	public DetalleFacturaCompra recuperarDetalleFactura(int id) {
		return daoDetalleFC.findById(id).orElse(null);
	}
	
	

	

}
