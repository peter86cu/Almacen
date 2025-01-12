package com.ayalait.stock.dao;




import org.springframework.data.jpa.repository.JpaRepository;

import com.ayalait.stock.modelo.*;


public interface ProductoDetallesJpaSpring extends JpaRepository<ProductoDetalles, String>{
	
	ProductoDetalles findAllByIdproducto(String id);
}
