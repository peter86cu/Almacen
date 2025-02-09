package com.ayalait.stock.service;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;

public interface ProductoVistoService {
	
	ResponseEntity<String> registrarProductoVisto(String usuarioId, String ip, String productoId, BigDecimal precio);
	
	ResponseEntity<String> obtenerProductosVistos(String usuarioId, String ip);

}
