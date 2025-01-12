package com.ayalait.stock.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ayalait.stock.modelo.*;


public interface SucursalJPASpring extends JpaRepository <Sucursal, String> {

	@Query(value="SELECT count(*) FROM sucursal WHERE idEmpresa=:idEmpresa and nombre=:nombre", nativeQuery=true)
	int buscarSucursalPorEmpresa(@Param("idEmpresa") String idEmpresa, @Param("nombre") String nombre);
	
	@Query(value="SELECT * FROM sucursal WHERE idEmpresa=:idEmpresa", nativeQuery=true)
	List<Sucursal> findByIdEmpresa(@Param("idEmpresa") String idEmpresa);
	

}
