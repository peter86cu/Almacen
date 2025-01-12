package com.ayalait.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import com.ayalait.stock.modelo.*;

import com.ayalait.stock.dao.*;

@Service
public class ParametrosOrdenCompraServiceImpl implements ParametrosOrdenCompraService {

	@Autowired
	ParametrosOrdenCompraDao service;

	@Override
	public ResponseEntity<String> listaFormasCobro() {
		try {
			List<FormasCobro> lst=service.obtenerFormasCobro();
			if(!lst.isEmpty()) {
				return new ResponseEntity<String>(new Gson().toJson(lst), HttpStatus.OK);
			}else{
				return new ResponseEntity<String>("No existen formas de cobro en la base de datos.",
						HttpStatus.BAD_REQUEST);
			}	
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
	}

	
	@Override
	public ResponseEntity<String> listaFormasPagos() {
		try {
			List<FormasPago> lstFormaPagos = service.obtenerFormasPagos();
			if (!lstFormaPagos.isEmpty()) {
				return new ResponseEntity<String>(new Gson().toJson(lstFormaPagos), HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("No existen formas de pagos en la base de datos.",
						HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
	}


	@Override
	public ResponseEntity<String> buscarProveedorPorID(int id) {
		try {
			Proveedor proveedor=service.buscarProveedorPorID(id);
			if(proveedor!=null) {
				return new ResponseEntity<String>(new Gson().toJson(proveedor), HttpStatus.OK);
			}else{
				return new ResponseEntity<String>("No existen el proveedor con id:"+id+ " en la base de datos.",
						HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getCause().getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
	}


	

}
