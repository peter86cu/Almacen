package com.ayalait.stock.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ayalait.stock.modelo.*;


public interface OrdenNumeroJpaSpring extends JpaRepository<OrdenNumero, Integer>{
	
	@Query(value="SELECT * from shopping_orden_numero", nativeQuery=true)
	OrdenNumero obtenerOrdenNumero();
}
