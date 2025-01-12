package com.ayalait.stock.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the formas_cobros database table.
 * 
 */
@Entity
@Table(name="formas_cobros")
@NamedQuery(name="FormasCobro.findAll", query="SELECT f FROM FormasCobro f")
public class FormasCobro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_forma_cobro")
	private int idFormaCobro;

	private String descripcion;

	private String simbolo;

	public FormasCobro() {
	}

	public int getIdFormaCobro() {
		return this.idFormaCobro;
	}

	public void setIdFormaCobro(int idFormaCobro) {
		this.idFormaCobro = idFormaCobro;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getSimbolo() {
		return this.simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

}