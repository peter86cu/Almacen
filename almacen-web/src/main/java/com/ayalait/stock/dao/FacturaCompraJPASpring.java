package com.ayalait.stock.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ayalait.stock.modelo.*;

public interface FacturaCompraJPASpring extends JpaRepository<FacturaCompra, Integer>{

    @Query(value="SELECT id_entrada_compra from entradas_compras  WHERE id_usuario =:id AND fecha_hora=:fecha", nativeQuery=true)
    int numeroFacturaCompraADD(@Param("id") String id, @Param("fecha") String fecha);
}
