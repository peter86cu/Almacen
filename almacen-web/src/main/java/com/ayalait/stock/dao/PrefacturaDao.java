package com.ayalait.stock.dao;




import java.util.List;

import org.springframework.stereotype.Component;

import com.ayalait.stock.modelo.*;





@Component
public interface PrefacturaDao {
	
	void crearPrefactura(Prefactura orden);
	String obtenerNumeroPrefactura(String fecha, String idUsuario);
	Prefactura obtenerPrefacturaPorId(String id);
	void guardarDetallePrefactura(PrefacturaDetalle detalle);
	PrefacturaDetalle recuperarDetallePrefacturaID(int id);
	void eliminarDetallePrefcatura(int id);
	List<Object> listadoPrefactura();
	void guardarModificacionPrefactura(PrefacturaModificaciones prefactura);
	List<Object> listadoPrefacturasAprobadas();
	Cliente obtenerClientePorID(String id);
	PrefacturaModificaciones obtenerModificacionPrefacturaId(int idPrefactura);
	int confirmarPedido(String id);
	

}
