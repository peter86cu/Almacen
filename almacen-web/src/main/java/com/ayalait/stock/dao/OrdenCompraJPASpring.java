package com.ayalait.stock.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ayalait.stock.modelo.*;

public interface OrdenCompraJPASpring extends JpaRepository<OrdenCompra, Integer>{

    //SELECT id_orden_compra from ordenes_de_compras  WHERE id_usuario ='8fe25c3e-a8c8-48a5-943e-b0e94cd11db5' AND fecha_hora=
    @Query(value="SELECT id_orden_compra from ordenes_de_compras  WHERE id_usuario =:id AND fecha_hora=:fecha", nativeQuery=true)
    int numeroOrdenCompraADD(@Param("id") String id, @Param("fecha") String fecha);
}
