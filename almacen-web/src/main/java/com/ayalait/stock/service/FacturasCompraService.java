package com.ayalait.stock.service;

import org.springframework.http.ResponseEntity;



public interface FacturasCompraService {

	ResponseEntity<String> crearFacturaCompra(String datos);

	ResponseEntity<String> obtenerNumeroFactura(String fecha, String idUsuario);

	ResponseEntity<String> obtenerFacturaCompraPorId(int id);

	ResponseEntity<String> guardarDetalleFactura(String detalle);

	ResponseEntity<String> recuperarDetalleFactura(int id);

}
