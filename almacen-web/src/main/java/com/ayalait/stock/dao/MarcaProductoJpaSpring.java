package com.ayalait.stock.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.ayalait.stock.modelo.*;


public interface MarcaProductoJpaSpring extends JpaRepository<MarcaProducto, Integer>{
}
