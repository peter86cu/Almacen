package com.ayalait.stock.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ayalait.stock.modelo.*;




public interface StockJpaSpring extends JpaRepository<Stock, Integer>{
	
	
	@Query("SELECT COALESCE(SUM(s.cantidad), -1) FROM Stock s WHERE s.idProducto = :idProducto")
	int getStockProductoId(@Param("idProducto") String idProducto);
	
}
