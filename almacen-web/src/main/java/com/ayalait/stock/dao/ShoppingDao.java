package com.ayalait.stock.dao;




import java.util.List;

import org.springframework.stereotype.Component;

import com.ayalait.stock.modelo.*;





@Component
public interface ShoppingDao {
	
	ShoppingCart guardarCarrito(ShoppingCart cart);
	ShoppingCartDetail guardarCarritoDetalle(ShoppingCartDetail detail);
	
	ShoppingCart obtenerCarritoCompra(String idCart, String idUsuario);
	List<ShoppingCartDetail> obtenerDettaleCartProducto(String idcart);
	List<ShoppingCart> obtenerCarritosPorUsuario(String idUsuario);
	
	void actualizarEstadoCart(String idCart);
	
	ShoppingHistoryEstado obtenerEstadoCarritoPorID(int id);
	
	OrdenNumero obtenerNumeroOrdenAGenerar();
	void actualizaNumeroOrden(OrdenNumero id);
	
	void crearOrdenPago(OrdenPago orden);
	OrdenPago obtenerOrdenPagoId(String id);
	
	List<OrdenPago> listadoOrdenesPorUsuario(String idusuario);
	
	int deleteCardbyId(String id);
	
	/*FacturaCompra obtenerFacturaCompraPorId(int id);
	void guardarDetalleFactura(DetalleFacturaCompra detalle);
	DetalleFacturaCompra recuperarDetalleFactura(int id);*/
	
	

}
