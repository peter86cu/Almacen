package com.ayalait.stock.modelo;


import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productos_vistos")
public class ProductoVisto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id")
    private String usuarioId; // Puede ser NULL si el usuario no está logueado

    @Column(name = "ip_conexion", length = 45, nullable = false)
    private String ipConexion; // Guarda la IP de la conexión si el usuario no está logueado

    @Column(name = "producto_id", nullable = false)
    private String productoId; // ID del producto que fue visto

    @Column(name = "precio", precision = 10, scale = 2, nullable = false)
    private BigDecimal precio; // Precio del producto en el momento en que fue visto

    @Column(name = "fecha_visto", nullable = false, updatable = false)
    private LocalDateTime fechaVisto = LocalDateTime.now(); // Guarda la fecha y hora cuando se vio el producto

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getIpConexion() {
		return ipConexion;
	}

	public void setIpConexion(String ipConexion) {
		this.ipConexion = ipConexion;
	}

	public String getProductoId() {
		return productoId;
	}

	public void setProductoId(String productoId) {
		this.productoId = productoId;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public LocalDateTime getFechaVisto() {
		return fechaVisto;
	}

	public void setFechaVisto(LocalDateTime fechaVisto) {
		this.fechaVisto = fechaVisto;
	}
    
    
}