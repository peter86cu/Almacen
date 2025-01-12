package com.ayalait.stock.modelo;

import java.math.BigDecimal;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ventas_cobros")
@NamedQuery(name = "VentasCobro.findAll", query = "SELECT v FROM VentasCobro v")
public class VentasCobro implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id_venta_cobro")
    private int idVentaCobro;
    private BigDecimal cobro;
    private int condicion;
    private BigDecimal cotizacion;
    @Column(name = "id_forma_cobro")
    private int idFormaCobro;
    @Column(name = "id_venta")
    private int idVenta;
    private int meses;
    @Column(name = "tasa_interes")
    private BigDecimal tasaInteres;
    private BigDecimal valor;
    
    public int getIdVentaCobro() {
        return this.idVentaCobro;
    }
    
    public void setIdVentaCobro(final int idVentaCobro) {
        this.idVentaCobro = idVentaCobro;
    }
    
    public BigDecimal getCobro() {
        return this.cobro;
    }
    
    public void setCobro(final BigDecimal cobro) {
        this.cobro = cobro;
    }
    
    public int getCondicion() {
        return this.condicion;
    }
    
    public void setCondicion(final int condicion) {
        this.condicion = condicion;
    }
    
    public BigDecimal getCotizacion() {
        return this.cotizacion;
    }
    
    public void setCotizacion(final BigDecimal cotizacion) {
        this.cotizacion = cotizacion;
    }
    
    public int getIdFormaCobro() {
        return this.idFormaCobro;
    }
    
    public void setIdFormaCobro(final int idFormaCobro) {
        this.idFormaCobro = idFormaCobro;
    }
    
    public int getIdVenta() {
        return this.idVenta;
    }
    
    public void setIdVenta(final int idVenta) {
        this.idVenta = idVenta;
    }
    
    public int getMeses() {
        return this.meses;
    }
    
    public void setMeses(final int meses) {
        this.meses = meses;
    }
    
    public BigDecimal getTasaInteres() {
        return this.tasaInteres;
    }
    
    public void setTasaInteres(final BigDecimal tasaInteres) {
        this.tasaInteres = tasaInteres;
    }
    
    public BigDecimal getValor() {
        return this.valor;
    }
    
    public void setValor(final BigDecimal valor) {
        this.valor = valor;
    }
}