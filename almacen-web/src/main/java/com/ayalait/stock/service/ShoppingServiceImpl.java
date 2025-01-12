package com.ayalait.stock.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import com.ayalait.stock.modelo.*;

import com.ayalait.stock.dao.*;
import com.ayalait.stock.vo.*;
import com.ayalait.utils.ErrorAPI;
import com.ayalait.utils.ErrorState;

@Service
public class ShoppingServiceImpl implements ShoppingService {

	private static final String RESULTADO_OK = "Datos guardado ok.";
	private static final String RESULTADO_NOK = "A ocurrido un error guardando los datos. Intente de nuevo.";
	public static final String DELETE_OK = "Registro eliminado correctamente.";
	public static final String DELETE_NOK = "El registro no existe.";

	@Autowired
	ShoppingDao daoSHopping;

	@Autowired
	ControlStockDao daoStock;

	@Override
	public ResponseEntity<String> guardarCarrito(String datos) {
		try {
			RequestAddCart request = new Gson().fromJson(datos, RequestAddCart.class);

			daoSHopping.guardarCarrito(request.getCart());

			if (!request.getDetalle().isEmpty()) {
				for (ShoppingCartDetail d : request.getDetalle()) {
					daoSHopping.guardarCarritoDetalle(d);
				}
			}
			daoSHopping.actualizarEstadoCart(request.getCart().getIdcart());
			return new ResponseEntity<String>(RESULTADO_OK, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<String> recuperarCarrito(String idCart, String idUsuario) {
		try {
			ResponseCart response = new ResponseCart();
			ShoppingCart cart = daoSHopping.obtenerCarritoCompra(idCart, idUsuario);
			if (cart != null) {
				response.setCart(cart);
				List<ShoppingCartDetail> lst = daoSHopping.obtenerDettaleCartProducto(idCart);
				List<ShoppingCartDetailResponse> lstTemp = new ArrayList<ShoppingCartDetailResponse>();
				if (!lst.isEmpty()) {
					for (int i = 0; i < lst.size(); i++) {
						Producto prod = daoStock.recuperarProductoPorId(lst.get(i).getIdproducto());
						if (prod != null) {
							ShoppingCartDetailResponse det = new ShoppingCartDetailResponse();
							det.setCantidad(i);
							det.setId(lst.get(i).getId());
							det.setIdcart(lst.get(i).getIdcart());
							det.setIdproducto(lst.get(i).getIdproducto());
							det.setPrecio(lst.get(i).getPrecio());
							det.setNombre(prod.getNombre());
							det.setImagen(prod.getFoto());
							det.setCantidad(lst.get(i).getCantidad());
							lstTemp.add(det);
						}

					}
					response.setDetalle(lstTemp);
				}
				return new ResponseEntity<String>(new Gson().toJson(response), HttpStatus.OK);
			} else {
				ErrorAPI err= new ErrorAPI();
				err.setCode(40001);
				err.setMessage("Error obteniendo el carriro");
				return new ResponseEntity<String>(new Gson().toJson(err), HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<String> obtenerCarritoPorUsuario(String idUsuario) {
		try {
			List<ResponseCart> resultado = new ArrayList<ResponseCart>();

			List<ShoppingCart> cart = daoSHopping.obtenerCarritosPorUsuario(idUsuario);

			if (!cart.isEmpty()) {

				for (ShoppingCart shoppingCart : cart) {
					ResponseCart response = new ResponseCart();
					response.setCart(shoppingCart);
					List<ShoppingCartDetailResponse> lstTemp = new ArrayList<ShoppingCartDetailResponse>();
					List<ShoppingCartDetail> lst = daoSHopping.obtenerDettaleCartProducto(shoppingCart.getIdcart());
					if (!lst.isEmpty()) {
						for (int i = 0; i < lst.size(); i++) {

							Producto prod = daoStock.recuperarProductoPorId(lst.get(i).getIdproducto());
							if (prod != null) {
								ShoppingCartDetailResponse det = new ShoppingCartDetailResponse();
								det.setCantidad(i);
								det.setId(lst.get(i).getId());
								det.setIdcart(lst.get(i).getIdcart());
								det.setIdproducto(lst.get(i).getIdproducto());
								det.setPrecio(lst.get(i).getPrecio());
								det.setNombre(prod.getNombre());
								det.setImagen(prod.getFoto());
								det.setCantidad(lst.get(i).getCantidad());
								lstTemp.add(det);
							}

						}
						response.setDetalle(lstTemp);

					}
					resultado.add(response);
				}

				return new ResponseEntity<String>(new Gson().toJson(resultado), HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("Error obteniendo el carrito de compra.", HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<String> obtenerEstadoCarritoPor(int id) {
		try {

			ShoppingHistoryEstado response = daoSHopping.obtenerEstadoCarritoPorID(id);
			if (response != null) {

				return new ResponseEntity<String>(new Gson().toJson(response), HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("Error obteniendo el estado del carrito de compra.",
						HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<String> obtenerNumeroOrdenAGenerar() {
		try {

			OrdenNumero response = daoSHopping.obtenerNumeroOrdenAGenerar();
			if (response !=null) {
				
				int nuevo=response.getValue()+1;
				response.setValue(nuevo);
				daoSHopping.actualizaNumeroOrden(response);
				return new ResponseEntity<String>(new Gson().toJson(response.getValue()), HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("Error obteniendo el estado del carrito de compra.",
						HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<String> crearOrdenPago(String datos) {
		
		try {
			OrdenPago request = new Gson().fromJson(datos, OrdenPago.class);

			daoSHopping.crearOrdenPago(request);
			
			return new ResponseEntity<String>(RESULTADO_OK, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<String> obtenerOrdePagoId(String idpago) {
		
		try {
			JsonParser jsonParser = new JsonParser();
		    JsonObject myJson = (JsonObject) jsonParser.parse(idpago);
		    
		OrdenPago response = daoSHopping.obtenerOrdenPagoId(myJson.get("payment_id").getAsString());
		if (response !=null) {			
			return new ResponseEntity<String>(new Gson().toJson(response), HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Error obteniendo la orden de compra.",
					HttpStatus.BAD_REQUEST);
		}

	} catch (Exception e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
	}
	}

	@Override
	public ResponseEntity<String> listadoOrdenesPorUsuario(String id) {
		try {
			ErrorState error= new ErrorState();
			List<OrdenPago> response = daoSHopping.listadoOrdenesPorUsuario(id);
			if (!response.isEmpty()) {
				
				return new ResponseEntity<String>(new Gson().toJson(response), HttpStatus.OK);
			} else {
				error.setCode(10001);
				return new ResponseEntity<String>(new Gson().toJson(error),
						HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
	}

}
