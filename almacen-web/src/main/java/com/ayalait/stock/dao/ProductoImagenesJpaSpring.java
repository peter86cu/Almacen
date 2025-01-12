package com.ayalait.stock.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayalait.stock.modelo.*;


public interface ProductoImagenesJpaSpring extends JpaRepository<ProductoImagenes, String>{
	
	List<ProductoImagenes> findAllByIdproducto(String id);
}
