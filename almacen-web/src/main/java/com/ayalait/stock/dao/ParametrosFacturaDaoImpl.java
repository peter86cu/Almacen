package com.ayalait.stock.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ayalait.stock.modelo.*;


@Repository
public class ParametrosFacturaDaoImpl implements ParametrosFacturaDao {

	@Autowired
	MonedaJPASpring daoMoneda;
	
	@Autowired
	DepositosJpaSpring daoDeposito;
	
	@Override
	public List<Moneda> obtenerMoneda() {
		
		return daoMoneda.findAll();
	}

	@Override
	public List<Depositos> obtenerDespositos() {
		return daoDeposito.findAll();
	}
	

}
