package com.ayalait.stock.modelo;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="sucursal")
public class Sucursal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="nombre")
	private String nombre;

	@Column(name="idEmpresa")
	private String idEmpresa;

	@Column(name="direccion")
	private String direccion;

	@Column(name="telefono")
	private String telefono;

	@Column(name="email")
	private String email;
	
	@Column(name="fechaInicio")
	private String fechaInicio;
	
	@Column(name="fechaFin")
	private String fechaFin;
	
	@Column(name="idEstado")
	private String idEstado;
	
	
	
	public Sucursal() {
		super();
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getIdEmpresa() {
		return idEmpresa;
	}



	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getFechaInicio() {
		return fechaInicio;
	}



	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}



	public String getFechaFin() {
		return fechaFin;
	}



	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}



	public String getIdEstado() {
		return idEstado;
	}



	public void setIdEstado(String idEstado) {
		this.idEstado = idEstado;
	}

	
}