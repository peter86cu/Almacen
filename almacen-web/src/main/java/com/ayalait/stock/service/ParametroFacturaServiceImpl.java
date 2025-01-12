package com.ayalait.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import com.ayalait.stock.modelo.*;
import com.ayalait.stock.vo.RequestCrearOrdenCompra;
import com.ayalait.stock.dao.*;

@Service
public class ParametroFacturaServiceImpl implements ParametroFacturaService {
	
	@Autowired
	ParametrosFacturaDao service;
	
	@Autowired
	ClienteJpaSpring daoCliente;

	@Override
	public ResponseEntity<String> obtenerMonedas() {
		try {
			List<Moneda> lstMoneda=service.obtenerMoneda();
			if(!lstMoneda.isEmpty()) {
				return new ResponseEntity<String>(new Gson().toJson(lstMoneda), HttpStatus.OK);
			}else{
				return new ResponseEntity<String>("No existen monedas en la base de datos.",
						HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getCause().getMessage(),
					HttpStatus.NOT_ACCEPTABLE);
		}
	}
	@Cacheable(cacheNames="depositos")
	@Override
	public ResponseEntity<String> obtenerDepositos() {
		try {
			List<Depositos> lstDespositos= service.obtenerDespositos();
			if(lstDespositos!=null)
				return new ResponseEntity<String>(new Gson().toJson(lstDespositos), HttpStatus.OK);
			return new ResponseEntity<String>("No existen monedas en la base de datos.",
					HttpStatus.BAD_REQUEST);

				
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getCause().getMessage(),
					HttpStatus.NOT_ACCEPTABLE);
		}
	}
	@Override
	public ResponseEntity<String> guardarCliente(String cliente) {
		try {
			Cliente request = new Gson().fromJson(cliente, Cliente.class);
			daoCliente.save(request);
			return new ResponseEntity<String>("Cliente guardado",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	

}
