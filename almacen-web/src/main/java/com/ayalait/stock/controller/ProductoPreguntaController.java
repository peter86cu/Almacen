package com.ayalait.stock.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayalait.stock.dto.PreguntaDTO;
import com.ayalait.stock.dto.RespuestaDTO;
import com.ayalait.stock.modelo.PreguntaRespuesta;
import com.ayalait.stock.service.StockService;

@RestController
@RequestMapping("/api/preguntas")
public class ProductoPreguntaController {

    @Autowired
    private StockService preguntaRespuestaService;

    // 1. Registrar una pregunta
    @PostMapping("/guardar")
    public ResponseEntity<?> guardarPregunta(@RequestBody PreguntaDTO preguntaDTO) {
        
           return preguntaRespuestaService.guardarPregunta(
                preguntaDTO.getIdProducto(),
                preguntaDTO.getIdUsuarioPregunta(),
                preguntaDTO.getPregunta()
            );
            //return ResponseEntity.ok(Map.of("code", 200, "message", "Pregunta registrada con éxito"));
        
    }

    // 2. Responder una pregunta
    @PostMapping("/responder")
    public ResponseEntity<?> responderPregunta(@RequestBody RespuestaDTO respuestaDTO) {
        
           return preguntaRespuestaService.responderPregunta(
                respuestaDTO.getIdPregunta(),
                respuestaDTO.getIdUsuarioRespuesta(),
                respuestaDTO.getRespuesta()
            );
           
    }

    // 3. Obtener preguntas de un producto
    @GetMapping("/producto/{idProducto}")
    public ResponseEntity<String> obtenerPreguntasPorProducto(@PathVariable String idProducto) {
    	return preguntaRespuestaService.obtenerPreguntasPorProducto(idProducto);
    	
           
    }
}
