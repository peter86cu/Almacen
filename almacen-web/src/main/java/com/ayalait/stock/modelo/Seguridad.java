package com.ayalait.stock.modelo;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="seguridad")
public class Seguridad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	private String id;
	
	
	@Column(name="id_usuario")
	private String idUsuario;
	
	@Column(name="fecha_inicio")
	private String fecha_login;
	
	@Column(name="fecha_fin")
	private String fecha_logout;
	
	@Column(name="token")
	private String token;
	
	@Column(name="accion")
	private String accion;
	
	@Column(name="metadata")
	private String metadata;
	
	@Column(name="resultado")
	private String resultado;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getFecha_login() {
		return fecha_login;
	}

	public void setFecha_login(String fecha_login) {
		this.fecha_login = fecha_login;
	}

	public String getFecha_logout() {
		return fecha_logout;
	}

	public void setFecha_logout(String fecha_logout) {
		this.fecha_logout = fecha_logout;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}
	

	public String getMetadata() {
		return metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}
	

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public Seguridad() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
