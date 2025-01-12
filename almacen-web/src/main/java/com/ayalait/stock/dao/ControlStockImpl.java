package com.ayalait.stock.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.ayalait.stock.modelo.*;



@Repository
public class ControlStockImpl implements ControlStockDao {

	@Autowired
	ProductoJPASpring daoProducto;
	
	@Autowired
	ProductoDetallesJpaSpring daoDetalles;
	
	@Autowired
	ProductoImagenesJpaSpring daoImagen;

	@Override
	public void guardarProducto(Producto producto) {
		 daoProducto.save(producto);		
	}	

	@Override
	public void eliminarProducto(String id) {
		daoProducto.deleteById(id);
	}

	@Override
	public Producto recuperarProductoPorId(String id) {		
		return daoProducto.findById(id).orElse(null);
	}

	@Override
	public List<Producto> listadoProductos() {
		return daoProducto.findAll();
	}

	@Override
	public Producto obtenerProductoPorNombre(String nombre) {
		return daoProducto.obtenerProductoPorNombre(nombre);
	}

	@Override
	public void guardarProductoImagen(ProductoImagenes imagenes) {
		daoImagen.save(imagenes);
		
	}

	@Override
	public void guardarProductoDetalle(ProductoDetalles detalle) {
		daoDetalles.save(detalle);
		
	}

	@Override
	public Producto obtenerProductoPorCodigo(String nombre) {
		
		return daoProducto.obtenerProductoPorCodigo(nombre);
		
	}

	@Override
	public List<ProductoImagenes> imagenesPorIdProducto(String idProducto) {
		
		return daoImagen.findAllByIdproducto(idProducto);
	}

	@Override
	public ProductoDetalles detalleProducto(String idProducto) {
		return daoDetalles.findAllByIdproducto(idProducto);
	}
	
	
	

	

}
