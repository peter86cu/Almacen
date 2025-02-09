package com.ayalait.stock.modelo;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;



@Entity
@Table(name = "control_existencias")
public class StockControlExistencia implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_control_existencia")
	private int idControlExistencia;
	
	@Column(name="id_producto")
	private String idProducto;
	
	@Column(name="fecha_baja")
	private Timestamp fechaHora;
	private int transaccion;
	private double cantidad;
	
	@Column(name="costo_unitario")
	private double costoUnitario;
	
	@Column(name="cantidad_resultante")
	private double cantidadResultante;
	
	@Column(name="costo_resultante")
	private double costoResultante;
	
	@Column(name="id_sucursal")
	private int idSucursal;
	
	@Column(name="id_moneda")
	private int idMoneda;
	
	@Column(name="id_factura")	
	private int idFactura;
	
	@Column(name="id_usuario")
	private String idUsuario;
	
	@Column(name="id_unidad_medida")
	private int idUnidadMedida;
	
	@Column(name="id_deposito")
	private int idDeposito;

	public int getIdControlExistencia() {
		return idControlExistencia;
	}

	public void setIdControlExistencia(int idControlExistencia) {
		this.idControlExistencia = idControlExistencia;
	}

	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public Timestamp getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Timestamp fechaHora) {
		this.fechaHora = fechaHora;
	}

	public int getTransaccion() {
		return transaccion;
	}

	public void setTransaccion(int transaccion) {
		this.transaccion = transaccion;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public double getCostoUnitario() {
		return costoUnitario;
	}

	public void setCostoUnitario(double costoUnitario) {
		this.costoUnitario = costoUnitario;
	}

	public double getCantidadResultante() {
		return cantidadResultante;
	}

	public void setCantidadResultante(double cantidadResultante) {
		this.cantidadResultante = cantidadResultante;
	}

	public double getCostoResultante() {
		return costoResultante;
	}

	public void setCostoResultante(double costoResultante) {
		this.costoResultante = costoResultante;
	}

	public int getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}

	public int getIdMoneda() {
		return idMoneda;
	}

	public void setIdMoneda(int idMoneda) {
		this.idMoneda = idMoneda;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdUnidadMedida() {
		return idUnidadMedida;
	}

	public void setIdUnidadMedida(int idUnidadMedida) {
		this.idUnidadMedida = idUnidadMedida;
	}

	public int getIdDeposito() {
		return idDeposito;
	}

	public void setIdDeposito(int idDeposito) {
		this.idDeposito = idDeposito;
	}

	public StockControlExistencia() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
