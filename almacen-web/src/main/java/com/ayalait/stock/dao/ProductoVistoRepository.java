package com.ayalait.stock.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayalait.stock.modelo.ProductoVisto;

@Repository
public interface ProductoVistoRepository extends JpaRepository<ProductoVisto, Long> {
    List<ProductoVisto> findByUsuarioIdOrderByFechaVistoDesc(String usuarioId);
    List<ProductoVisto> findByIpConexionOrderByFechaVistoDesc(String ip);
}
