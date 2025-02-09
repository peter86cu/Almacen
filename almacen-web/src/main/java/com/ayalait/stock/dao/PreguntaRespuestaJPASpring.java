package com.ayalait.stock.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



import com.ayalait.stock.modelo.*;

public interface PreguntaRespuestaJPASpring extends JpaRepository<PreguntaRespuesta, Integer>{

	// Obtener preguntas de un producto por ID
    List<PreguntaRespuesta> findByIdProducto(String idProducto);
}
