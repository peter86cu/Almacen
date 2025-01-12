package com.ayalait.stock.service;


import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import com.ayalait.stock.modelo.*;

import com.ayalait.stock.dao.*;
import com.ayalait.stock.vo.*;

@Service
public class OrdenCompraServiceImpl implements OrdenCompraService {

	private static final String RESULTADO_OK = "Datos guardado ok.";
	public static final String DELETE_OK="Registro eliminado correctamente.";
	public static final String DELETE_NOK="El registro no existe.";
	public static final String ITEMS_OK="Producto agregado.";
	
	@Autowired
	OrdenCompraDao daoStock;

	@Override
	public ResponseEntity<String> crearOrdenCompra(String orden) {
		try {
			RequestCrearOrdenCompra request = new Gson().fromJson(orden, RequestCrearOrdenCompra.class);
			daoStock.crearOrdenCompra(request.getOrdenCompra());
			return new ResponseEntity<String>(RESULTADO_OK,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<String> obtenerNumeroOrden(String fecha, String idUsuario) {
		try {
			int resultado= daoStock.obtenerNumeroOrden(fecha, idUsuario);
			return new ResponseEntity<String>(String.valueOf(resultado),HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<String> obtenerOrdenCompraPorId(int id) {
		try {
			OrdenCompra orden=daoStock.obtenerOrdenCompraPorId(id);
			if(orden!=null) {
				return new ResponseEntity<String>(new Gson().toJson(orden), HttpStatus.OK);
			}else {
				return new ResponseEntity<String>("No existen la orden :"+id, HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);

		}
		

	}

	@Override
	public ResponseEntity<String> guardarDetalleOC(String detalle) {
		try {
			RequestGuardarDetalleOC request = new Gson().fromJson(detalle, RequestGuardarDetalleOC.class);
			daoStock.guardarDetalleOrdenCompra(request.getDetalleOrdenCompra());
			return new ResponseEntity<String>(ITEMS_OK,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getCause().getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<String> eliminarDetalleOrdenCompra(int id) {
		try {
			if(daoStock.recuperarDetalleOrdenCompraID(id)!=null) {
				daoStock.eliminarDetalleOrdenCompra(id);
				return new ResponseEntity<String>(DELETE_OK,HttpStatus.OK);
			}
			return new ResponseEntity<String>(DELETE_NOK,HttpStatus.BAD_REQUEST);

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<String> salvarModificacionesOC(String datos) {
		try {
			RequestSalvarModifOC request = new Gson().fromJson(datos, RequestSalvarModifOC.class);
			daoStock.guardarModificacionOC(request.getOrdenCompraModif());
			return new ResponseEntity<String>(RESULTADO_OK,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
	}

	

}
