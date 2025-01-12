package com.ayalait.stock.dao;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.ayalait.stock.modelo.*;



@Repository
public class ShoppingImpl implements ShoppingDao {

	
	@Autowired
	ShoppingCartJpaSpring daoCart;
	
	@Autowired
	ShoppingCartDetailJpaSpring daoDetalle;
	
	@Autowired
	ShoppingHEstadoJpaSpring daoEstadoH;


	@Autowired
	OrdenNumeroJpaSpring daoNum;
	
	@Autowired
	OrdenPagoJPASpring daoOrden;

	@Override
	public void guardarCarrito(ShoppingCart cart) {
		daoCart.save(cart);
		
	}

	@Override
	public void guardarCarritoDetalle(ShoppingCartDetail detail) {
		daoDetalle.save(detail);
		
	}

	@Override
	public ShoppingCart obtenerCarritoCompra(String idCart, String idUsuario) {
		return daoCart.findByIdcartAndIdusuario(idCart, idUsuario);
	}

	@Override
	public List<ShoppingCartDetail> obtenerDettaleCartProducto(String idcart) {
		
		return daoDetalle.findByIdcart(idcart);
	}

	
	@Override
	public void actualizarEstadoCart(String idCart) {
		 daoCart.actualizarEstadoCart(idCart);
		
	}

	@Override
	public List<ShoppingCart> obtenerCarritosPorUsuario(String idUsuario) {
		return daoCart.findByIdusuario(idUsuario);
	}

	@Override
	public ShoppingHistoryEstado obtenerEstadoCarritoPorID(int id) {
		return daoEstadoH.findById(id).orElse(null);
	}

	@Override
	public OrdenNumero obtenerNumeroOrdenAGenerar() {
		return daoNum.findAll().stream().findFirst().get();
	}

	@Override
	public void actualizaNumeroOrden(OrdenNumero id) {
		daoNum.save(id);
		
	}

	@Override
	public void crearOrdenPago(OrdenPago orden) {
		daoOrden.save(orden);
		
	}

	@Override
	public OrdenPago obtenerOrdenPagoId(String id) {
		
		return daoOrden.findByIdpago(id);
	}

	@Override
	public List<OrdenPago> listadoOrdenesPorUsuario(String idusuario) {
		 return daoOrden.findAllByIdusuario(idusuario);
	}
	
	

	

}
