package com.ayalait.stock.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.ayalait.stock.modelo.*;


public interface ShoppingCartJpaSpring extends JpaRepository<ShoppingCart, String>{
	
	ShoppingCart findByIdcartAndIdusuario(String idcart, String idusuario);
	
	List<ShoppingCart> findByIdusuario(String idusuario);
	
	  @Procedure(name = "actualizarEstadoCart")
	    void actualizarEstadoCart(@Param("idCart") String inputParam1);
}
