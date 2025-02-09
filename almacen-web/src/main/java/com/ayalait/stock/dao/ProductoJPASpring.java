package com.ayalait.stock.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ayalait.stock.modelo.*;




public interface ProductoJPASpring extends JpaRepository<Producto, String>{

	@Query(value="SELECT * FROM producto WHERE nombre=:nombre", nativeQuery=true)
	Producto obtenerProductoPorNombre(@Param("nombre") String nombre);
	
	@Query(value="SELECT * FROM producto WHERE codigo=:codigo", nativeQuery=true)
	Producto obtenerProductoPorCodigo(@Param("codigo") String nombre);
	
	@Query(value="SELECT * FROM producto WHERE (tipoproducto =:idTipoProducto OR categoria =:idCategoriaProducto)", nativeQuery=true)
	List<Producto> obtenerProductosRelacionados(@Param("idTipoProducto") int idTipoProducto, @Param("idCategoriaProducto") int idCategoriaProducto);
}
