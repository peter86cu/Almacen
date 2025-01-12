package com.ayalait.stock.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ayalait.stock.modelo.*;


public interface MonedaJPASpring extends JpaRepository <Moneda, String> {

	@Query(value="SELECT * FROM moneda WHERE idEmpresa=:id and codigo=:codigo", nativeQuery=true)
	Moneda buscarMonedaPorIdEmpresa(@Param("id") String id, @Param("codigo") String codigo);	
	
	@Query(value="SELECT id FROM moneda WHERE defecto=1", nativeQuery=true)
	int buscaridMonedaDefault();

}
