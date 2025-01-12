package com.ayalait.stock.modelo;


import javax.persistence.*;
import java.io.Serializable;



@Entity
@Table(name = "shopping_orden_numero")
public class OrdenNumero implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	private int value;
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public OrdenNumero() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getValue() {
		return value;
	}


	public void setValue(int value) {
		this.value = value;
	}



	

}
