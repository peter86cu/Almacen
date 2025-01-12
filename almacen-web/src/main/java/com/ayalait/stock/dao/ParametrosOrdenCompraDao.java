package com.ayalait.stock.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ayalait.stock.modelo.*;

@Component
public interface ParametrosOrdenCompraDao {

	// FormasPagos
	List<FormasPago> obtenerFormasPagos();

	// Formas de cobros
	List<FormasCobro> obtenerFormasCobro();
	
	//Buscar orden de compra por id
	Proveedor buscarProveedorPorID(int id);

}
