package com.ayalait.stock.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ayalait.stock.dao.ProductoVistoRepository;
import com.ayalait.stock.modelo.ProductoVisto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.Gson;

@Service
public class ProductoVistoServiceImpl implements ProductoVistoService {
	
	@Autowired
    private ProductoVistoRepository productoVistoRepository;
	
	ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public ResponseEntity<String> registrarProductoVisto(String usuarioId, String ip, String productoId,
			BigDecimal precio) {
		try {
			
			 ProductoVisto productoVisto = new ProductoVisto();
		        productoVisto.setUsuarioId(usuarioId);
		        productoVisto.setIpConexion(ip);
		        productoVisto.setProductoId(productoId);
		        productoVisto.setPrecio(precio);
		        productoVisto.setFechaVisto(LocalDateTime.now());
		      		       
		        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
				objectMapper.registerModule(new JavaTimeModule());

	            String json = objectMapper.writeValueAsString(productoVistoRepository.save(productoVisto));
				return new ResponseEntity<String>(json, HttpStatus.OK);				
		        
			
		} catch (Exception e) {
			return new ResponseEntity<String>(new Gson().toJson("Ocurrio un error guardando los datos"),HttpStatus.NOT_ACCEPTABLE);

		}
	}

	@Override
	public ResponseEntity<String> obtenerProductosVistos(String usuarioId, String ip) {
		try {
			if (!usuarioId.equalsIgnoreCase("0000000000")) {
				 objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
					objectMapper.registerModule(new JavaTimeModule());
					 String json = objectMapper.writeValueAsString(productoVistoRepository.findByUsuarioIdOrderByFechaVistoDesc(usuarioId));

					 return new ResponseEntity<String>(json, HttpStatus.OK);	
		    } else {
		    	 objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
					objectMapper.registerModule(new JavaTimeModule());
					 String json = objectMapper.writeValueAsString(productoVistoRepository.findByIpConexionOrderByFechaVistoDesc(ip));
					return new ResponseEntity<String>(json, HttpStatus.OK);	

		    }
			
			
		} catch (Exception e) {
			return new ResponseEntity<String>(new Gson().toJson("Ocurrio un error obteniendo los datos"),HttpStatus.NOT_ACCEPTABLE);
		}
	}

}
