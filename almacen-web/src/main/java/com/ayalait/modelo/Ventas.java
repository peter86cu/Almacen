package com.ayalait.modelo;


public class Ventas  {

	private int id_venta; 
	private int estado; 
	private String id_usuario;
	private String fecha_hora; 
	private String fecha_hora_cerrado; 
	private String id_usuario_autoriza;
	private int id_sucursal; 
	private String fecha_baja; 
	private int movimiento; 
	private double monto_total; 
	private String id_cliente; 
	private int id_apertura_cajero;
	private int nro_consecutivo; 
	private double iva5; 
	private double iva10; 
	private int condicion; 
	private double monto_credito; 
	private double redondeo;
	private String id_transaccion;
	

	public Ventas() {
	}


	public int getId_venta() {
		return id_venta;
	}


	public void setId_venta(int id_venta) {
		this.id_venta = id_venta;
	}


	public int getEstado() {
		return estado;
	}


	public void setEstado(int estado) {
		this.estado = estado;
	}


	public String getId_usuario() {
		return id_usuario;
	}


	public void setId_usuario(String id_usuario) {
		this.id_usuario = id_usuario;
	}


	public String getFecha_hora() {
		return fecha_hora;
	}


	public void setFecha_hora(String fecha_hora) {
		this.fecha_hora = fecha_hora;
	}


	public String getFecha_hora_cerrado() {
		return fecha_hora_cerrado;
	}


	public void setFecha_hora_cerrado(String fecha_hora_cerrado) {
		this.fecha_hora_cerrado = fecha_hora_cerrado;
	}


	public String getId_usuario_autoriza() {
		return id_usuario_autoriza;
	}


	public void setId_usuario_autoriza(String id_usuario_autoriza) {
		this.id_usuario_autoriza = id_usuario_autoriza;
	}


	public int getId_sucursal() {
		return id_sucursal;
	}


	public void setId_sucursal(int id_sucursal) {
		this.id_sucursal = id_sucursal;
	}


	public String getFecha_baja() {
		return fecha_baja;
	}


	public void setFecha_baja(String fecha_baja) {
		this.fecha_baja = fecha_baja;
	}


	public int getMovimiento() {
		return movimiento;
	}


	public void setMovimiento(int movimiento) {
		this.movimiento = movimiento;
	}


	public double getMonto_total() {
		return monto_total;
	}


	public void setMonto_total(double monto_total) {
		this.monto_total = monto_total;
	}


	public String getId_cliente() {
		return id_cliente;
	}


	public void setId_cliente(String id_cliente) {
		this.id_cliente = id_cliente;
	}


	public int getId_apertura_cajero() {
		return id_apertura_cajero;
	}


	public void setId_apertura_cajero(int id_apertura_cajero) {
		this.id_apertura_cajero = id_apertura_cajero;
	}


	public int getNro_consecutivo() {
		return nro_consecutivo;
	}


	public void setNro_consecutivo(int nro_consecutivo) {
		this.nro_consecutivo = nro_consecutivo;
	}


	public double getIva5() {
		return iva5;
	}


	public void setIva5(double iva5) {
		this.iva5 = iva5;
	}


	public double getIva10() {
		return iva10;
	}


	public void setIva10(double iva10) {
		this.iva10 = iva10;
	}


	public int getCondicion() {
		return condicion;
	}


	public void setCondicion(int condicion) {
		this.condicion = condicion;
	}


	public double getMonto_credito() {
		return monto_credito;
	}


	public void setMonto_credito(double monto_credito) {
		this.monto_credito = monto_credito;
	}


	public double getRedondeo() {
		return redondeo;
	}


	public void setRedondeo(double redondeo) {
		this.redondeo = redondeo;
	}


	public String getId_transaccion() {
		return id_transaccion;
	}


	public void setId_transaccion(String id_transaccion) {
		this.id_transaccion = id_transaccion;
	}

	

}