package com.ayalait.stock.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.ayalait.stock.modelo.*;

@Repository
public class ParametrosOrdenCompraImpl implements ParametrosOrdenCompraDao {

	@Autowired
	FormasPagoJpaSpring daoFormaPago;
	
	@Autowired
	FormaCobroJpaSpring daoFormaCobro;
	
	
	@Autowired
	ProveedorlJPASpring daoProveedor;
	
	
	@Override
	public List<FormasPago> obtenerFormasPagos() {
		
		return daoFormaPago.findAll();
	}


	@Override
	public List<FormasCobro> obtenerFormasCobro() {
		
		return daoFormaCobro.findAll();
	}


	@Override
	public Proveedor buscarProveedorPorID(int id) {
		return daoProveedor.findById(id).orElse(null);
	}

	

}
