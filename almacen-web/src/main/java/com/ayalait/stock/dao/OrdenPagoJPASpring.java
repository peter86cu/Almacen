package com.ayalait.stock.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayalait.stock.modelo.*;



public interface OrdenPagoJPASpring extends JpaRepository<OrdenPago, String>{

	OrdenPago findByIdpago(String id);
	
	List<OrdenPago> findAllByIdusuario(String id);
}
