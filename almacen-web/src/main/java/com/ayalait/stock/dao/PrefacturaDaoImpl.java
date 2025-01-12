package com.ayalait.stock.dao;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.ayalait.stock.modelo.*;



@Repository
public class PrefacturaDaoImpl implements PrefacturaDao {

	@Autowired
	PrefacturaJpa daoPrefactura;
	
	@Autowired
	PrefacturaDetalleJpa daoDetalle;
	

	@Autowired
	PrefacturaModificacionesJpa daoModif;
	
	@Autowired
	ClienteJpaSpring daoCliente;
	
	@Override
	public void crearPrefactura(Prefactura orden) {
		daoPrefactura.save(orden);
		
	}

	@Override
	public Prefactura obtenerPrefacturaPorId(String id) {
		return daoPrefactura.findById(id).orElse(null);
	}

	@Override
	public void guardarDetallePrefactura(PrefacturaDetalle detalle) {
		daoDetalle.save(detalle);
		
	}

	@Override
	public PrefacturaDetalle recuperarDetallePrefacturaID(int id) {		
		return daoDetalle.findById(id).orElse(null);
	}

	@Override
	public void eliminarDetallePrefcatura(int id) {
		daoDetalle.deleteById(id);
		
	}

	@Override
	public String obtenerNumeroPrefactura(String fecha, String idUsuario) {
		return daoPrefactura.numeroPrefacturaADD(idUsuario,fecha);
	}

	@Override
	public List<Object> listadoPrefactura() {
		return daoPrefactura.findPrefactura();
	}

	@Override
	public void guardarModificacionPrefactura(PrefacturaModificaciones prefactura) {
		daoModif.save(prefactura);
		
	}

	@Override
	public List<Object> listadoPrefacturasAprobadas() {		
		return daoModif.findPrefacturaModificadas();
	}

	@Override
	public PrefacturaModificaciones obtenerModificacionPrefacturaId(int idPrefactura) {
		return daoModif.findById_usuario_cancela(idPrefactura);
	}

	@Override
	public Cliente obtenerClientePorID(String id) {
		
		return daoCliente.buscarClientePorID(id);
	}

	@Override
	public int confirmarPedido(String id) {
		return daoPrefactura.confirmarPedido(id);
		
	}

	
	
	

	

}
