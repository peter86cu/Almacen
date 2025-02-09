package com.ayalait.stock.service;


import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ayalait.stock.modelo.PreguntaRespuesta;


public interface StockService {

ResponseEntity<String> addProductos(String producto);
	
ResponseEntity<String> eliminarProductos(String idProducto);
	
ResponseEntity<String> listadoProductos();	

ResponseEntity<String> recuperarProductoPorId(String id);

ResponseEntity<String> imagenesPorProducto(String id);

ResponseEntity<String> detallesPorProductos(String id);

ResponseEntity<String> obtenerProductoPorCodigo(String codigo);

ResponseEntity<String> obtenerStockProductoId(String id);	

ResponseEntity<String> guardarResena(String idProducto, int puntuacion, String comentario);

ResponseEntity<?> guardarPregunta(String idProducto, String idUsuarioPregunta, String pregunta);

ResponseEntity<?> responderPregunta(int idPregunta, String idUsuarioRespuesta, String respuesta);

ResponseEntity<String> obtenerPreguntasPorProducto(String idProducto);

ResponseEntity<String> obtenerProductosRelacionados(int idTipoProducto, int idCategoriaProducto);
	
}
