package com.ayalait.stock.dao;



import java.util.List;

import org.springframework.stereotype.Component;

import com.ayalait.stock.modelo.*;



@Component
public interface ControlStockDao {
	
	
	//Datos productos
		void guardarProducto(Producto producto);
		
		void guardarProductoImagen(ProductoImagenes imagenes);
		
		void guardarProductoDetalle(ProductoDetalles detalle);
		
		void eliminarProducto(String id);
		
		Producto recuperarProductoPorId(String id);
		
		Producto obtenerProductoPorNombre(String nombre);
		
		Producto obtenerProductoPorCodigo(String nombre);
		
		List<Producto> listadoProductos();
		
		List<ProductoImagenes> imagenesPorIdProducto(String idProducto);
		
		ProductoDetalles detalleProducto(String idProducto);

	

}
