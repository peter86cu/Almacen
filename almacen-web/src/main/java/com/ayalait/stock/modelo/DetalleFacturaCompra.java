package com.ayalait.stock.modelo;


import javax.persistence.*;

@Entity
@Table(name = "entradas_compras_detalle")
public class DetalleFacturaCompra
{
    @Id
    private int id_entrada_compra_detalle;
    private String id_producto;
    private int cantidad;
    private int id_entrada_compra;
    private double importe;
    private int id_moneda;
    
    public int getId_entrada_compra_detalle() {
        return this.id_entrada_compra_detalle;
    }
    
    public void setId_entrada_compra_detalle(final int id_entrada_compra_detalle) {
        this.id_entrada_compra_detalle = id_entrada_compra_detalle;
    }
    
    public String getId_producto() {
        return this.id_producto;
    }
    
    public void setId_producto(final String id_producto) {
        this.id_producto = id_producto;
    }
    
    public int getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(final int cantidad) {
        this.cantidad = cantidad;
    }
    
    public int getId_entrada_compra() {
        return this.id_entrada_compra;
    }
    
    public void setId_entrada_compra(final int id_entrada_compra) {
        this.id_entrada_compra = id_entrada_compra;
    }
    
    public double getImporte() {
        return this.importe;
    }
    
    public void setImporte(final double importe) {
        this.importe = importe;
    }
    
    public int getId_moneda() {
        return this.id_moneda;
    }
    
    public void setId_moneda(final int id_moneda) {
        this.id_moneda = id_moneda;
    }
}