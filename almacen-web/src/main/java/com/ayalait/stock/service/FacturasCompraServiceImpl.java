package com.ayalait.stock.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import com.ayalait.stock.modelo.*;

import com.ayalait.stock.dao.*;
import com.ayalait.stock.vo.*;

@Service
public class FacturasCompraServiceImpl implements FacturasCompraService {

	private static final String RESULTADO_OK = "Datos guardado ok.";
	private static final String RESULTADO_NOK = "A ocurrido un error guardando los datos. Intente de nuevo.";
	public static final String DELETE_OK="Registro eliminado correctamente.";
	public static final String DELETE_NOK="El registro no existe.";
	public static final String ITEMS_OK="Producto agregado.";

	
	@Autowired
	FacturasCompraDao daoFactura;

	@Override
	public ResponseEntity<String> crearFacturaCompra(String datos) {
		try {
			System.out.println(datos);
			RequestFacturaCompra request = new Gson().fromJson(datos, RequestFacturaCompra.class);
			daoFactura.crearFacturaCompra(request.getFacturaCompra());
				return new ResponseEntity<String>(RESULTADO_OK,HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<String> obtenerNumeroFactura(String fecha, String idUsuario) {
		try {
			int resultado= daoFactura.obtenerNumeroFactura(fecha, idUsuario);
			
			return new ResponseEntity<String>(String.valueOf(resultado),HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.OK);
		}
	}

	@Override
	public ResponseEntity<String> obtenerFacturaCompraPorId(int id) {
		try {
			FacturaCompra factura =daoFactura.obtenerFacturaCompraPorId(id);
			if(factura!=null) {
				return new ResponseEntity<String>(new Gson().toJson(factura), HttpStatus.OK);
			}else {
				return new ResponseEntity<String>("No existen la factura :"+id, HttpStatus.BAD_REQUEST);
			}

			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);

		}
	}

	@Override
	public ResponseEntity<String> guardarDetalleFactura(String detalle) {
		try {
			RequestGuardarDetalleFC request = new Gson().fromJson(detalle, RequestGuardarDetalleFC.class);
			daoFactura.guardarDetalleFactura(request.getDetalleFacturaCompra());
			return new ResponseEntity<String>(ITEMS_OK,HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getCause().getMessage(),HttpStatus.NOT_ACCEPTABLE);

		}
	}

	@Override
	public ResponseEntity<String> recuperarDetalleFactura(int id) {
		try {
			DetalleFacturaCompra detalle= daoFactura.recuperarDetalleFactura(id);
			if(detalle!=null) {
				return new ResponseEntity<String>(new Gson().toJson(detalle),HttpStatus.OK);
			}
			return new ResponseEntity<String>("No se encontro el detalle de la factura: "+id,HttpStatus.BAD_REQUEST);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getCause().getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
	}

	

}
