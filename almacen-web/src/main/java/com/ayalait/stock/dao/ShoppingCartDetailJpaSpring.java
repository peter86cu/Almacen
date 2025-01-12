package com.ayalait.stock.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayalait.stock.modelo.*;


public interface ShoppingCartDetailJpaSpring extends JpaRepository<ShoppingCartDetail, String>{
	
	List<ShoppingCartDetail> findByIdcart(String idcart);
}
