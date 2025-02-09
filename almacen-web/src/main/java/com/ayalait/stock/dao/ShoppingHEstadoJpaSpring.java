package com.ayalait.stock.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ayalait.stock.modelo.*;

public interface ShoppingHEstadoJpaSpring extends JpaRepository<ShoppingHistoryEstado, Integer> {

	@Modifying
    @Transactional // Asegura que la consulta se ejecuta dentro de una transacción
	@Query("UPDATE ShoppingHistoryEstado e SET e.idestado = :idestado, e.descripcion = :descripcion WHERE e.idcart = :idcart")
	int actualizarEstadoYDescripcion(@Param("idestado") int idestado, @Param("descripcion") String descripcion,
			@Param("idcart") String idcart);

}
