package com.ayalait.stock.dao;

import java.util.List;

import org.springframework.stereotype.Component;


import com.ayalait.stock.modelo.*;

@Component
public interface ParametrosFacturaDao {
	
	 List<Moneda> obtenerMoneda();
	 List<Depositos> obtenerDespositos();


}
