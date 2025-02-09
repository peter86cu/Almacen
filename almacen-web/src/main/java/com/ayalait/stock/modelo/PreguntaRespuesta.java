package com.ayalait.stock.modelo;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.ayalait.fecha.CustomTimestampDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


@Entity
@Table(name = "producto_preguntas")
public class PreguntaRespuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPregunta;

    private String idProducto;
    private String idUsuarioPregunta;
    private String idUsuarioRespuesta;
    private String pregunta;
    private String respuesta;
    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp fechaPregunta;
    
    private Timestamp fechaRespuesta;
    private int estado; // 0 = Sin responder, 1 = Respondida

    @ManyToOne
    @JoinColumn(name = "idProducto", referencedColumnName = "id", insertable = false, updatable = false)
    private Producto producto;
    
    @ManyToOne
    @JoinColumn(name = "idUsuarioPregunta", referencedColumnName = "id", insertable = false, updatable = false)
    private ShoppingUsuarios usuarioPregunta;

    
    @ManyToOne
    @JoinColumn(name = "idUsuarioRespuesta", referencedColumnName = "id", insertable = false, updatable = false)
    private ShoppingUsuarios usuarioRespuesta;

   
	

	public String getIdUsuarioPregunta() {
		return idUsuarioPregunta;
	}

	public void setIdUsuarioPregunta(String idUsuarioPregunta) {
		this.idUsuarioPregunta = idUsuarioPregunta;
	}

	public String getIdUsuarioRespuesta() {
		return idUsuarioRespuesta;
	}

	public void setIdUsuarioRespuesta(String idUsuarioRespuesta) {
		this.idUsuarioRespuesta = idUsuarioRespuesta;
	}

	public ShoppingUsuarios getUsuarioPregunta() {
		return usuarioPregunta;
	}

	public void setUsuarioPregunta(ShoppingUsuarios usuarioPregunta) {
		this.usuarioPregunta = usuarioPregunta;
	}

	public ShoppingUsuarios getUsuarioRespuesta() {
		return usuarioRespuesta;
	}

	public void setUsuarioRespuesta(ShoppingUsuarios usuarioRespuesta) {
		this.usuarioRespuesta = usuarioRespuesta;
	}

	public int getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}

	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public Timestamp getFechaPregunta() {
		return fechaPregunta;
	}

	public void setFechaPregunta(Timestamp fechaPregunta) {
		this.fechaPregunta = fechaPregunta;
	}

	public Timestamp getFechaRespuesta() {
		return fechaRespuesta;
	}

	public void setFechaRespuesta(Timestamp fechaRespuesta) {
		this.fechaRespuesta = fechaRespuesta;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

    
}

