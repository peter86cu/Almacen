package com.ayalait.stock.service;

import java.util.List;
import java.util.Map;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import com.ayalait.stock.modelo.*;

import com.ayalait.stock.dao.*;
import com.ayalait.stock.vo.*;
import com.ayalait.utils.ErrorAPI;

@Service
public class StockServiceImpl implements StockService {

	private static final String RESULTADO_OK = "Datos guardado ok.";
	private static final String RESULTADO_NOK = "A ocurrido un error guardando los datos. Intente de nuevo.";
	public static final String DELETE_OK="Registro eliminado correctamente.";
	public static final String DELETE_NOK="El registro no existe.";
	
	@Autowired
	ControlStockDao daoStock;
	
	@Autowired
	PreguntaRespuestaJPASpring daoPreguntaRespuesta;

	@Override
	public ResponseEntity<String> addProductos(String producto) {
		System.out.println(producto);

		try {
			RequestAddProducto request = new Gson().fromJson(producto, RequestAddProducto.class);
			if (request.getAccion().equalsIgnoreCase("Add")) {
				//request.getProducto().setMoneda(1);

				daoStock.guardarProducto(request.getProducto());
				
				//Producto insert= daoStock.obtenerProductoPorCodigo(request.getProducto().getCodigo());
				if(!request.getImagenes().isEmpty()) {
					for(ProductoImagenes imagen: request.getImagenes()) {
						imagen.setIdproducto(request.getProducto().getId());
						daoStock.guardarProductoImagen(imagen);
					}
				}
				if(request.getProducto()!=null) {
					ProductoDetalles detalle=request.getDetalle();
					//if(detalle.getIdproducto()!=null) {
						detalle.setIdproducto(request.getProducto().getId());
						daoStock.guardarProductoDetalle(detalle);
					//}
					
					
				}
				
				return new ResponseEntity<String>(RESULTADO_OK, HttpStatus.OK);
				
			} else {
				daoStock.guardarProducto(request.getProducto());
				return new ResponseEntity<String>(RESULTADO_OK, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}

	}

	@Override
	public ResponseEntity<String> eliminarProductos(String idProducto) {
		try {
			daoStock.eliminarProducto(idProducto);
			return new ResponseEntity<String>(DELETE_OK,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public  ResponseEntity<String> listadoProductos() {
		try {
			List<Producto> lstProductos=daoStock.listadoProductos();
			if(!lstProductos.isEmpty()) {
				return new ResponseEntity<String>(new Gson().toJson(lstProductos), HttpStatus.OK);
			}else {
				return new ResponseEntity<String>("No existen productos en la base.", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<String> recuperarProductoPorId(String id) {
		try {
			Producto producto=daoStock.recuperarProductoPorId(id);
			if(producto!=null) {
				return new ResponseEntity<String>(new Gson().toJson(producto), HttpStatus.OK);
			}else {
				return new ResponseEntity<String>("No existe el producto.", HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<String> imagenesPorProducto(String id) {
		try {
			List<ProductoImagenes> lstImagen=daoStock.imagenesPorIdProducto(id);
			if(!lstImagen.isEmpty()) {
				return new ResponseEntity<String>(new Gson().toJson(lstImagen), HttpStatus.OK);
			}else {
				ErrorAPI err= new ErrorAPI();
				err.setCode(40002);
				err.setMessage("No existen imagenes para ese id de productos en la base.");
				return new ResponseEntity<String>(new Gson().toJson(err), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<String> detallesPorProductos(String id) {
		try {
			ProductoDetalles lstDetail=daoStock.detalleProducto(id);
			if(lstDetail!=null) {
				return new ResponseEntity<String>(new Gson().toJson(lstDetail), HttpStatus.OK);
			}else {
				ErrorAPI err= new ErrorAPI();
				err.setCode(40003);
				err.setMessage("No existen detalle para ese id de productos en la base.");
				
				return new ResponseEntity<String>(new Gson().toJson(err), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<String> obtenerProductoPorCodigo(String codigo) {
		try {
			Producto producto=daoStock.obtenerProductoPorCodigo(codigo);
			if(producto!=null) {
				return new ResponseEntity<String>(new Gson().toJson(producto), HttpStatus.OK);
			}else {
				return new ResponseEntity<String>("No existe el producto.", HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<String> obtenerStockProductoId(String id) {
		try {
			int producto=daoStock.getStockProductoId(id);
			if(producto!=-1) {
				return new ResponseEntity<String>(new Gson().toJson(producto), HttpStatus.OK);
			}else {
				return new ResponseEntity<String>("No hay stock ", HttpStatus.CREATED);
			}
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<String> guardarResena(String idProducto, int puntuacion, String comentario) {
		try {
			Review review = new Review();
		    review.setIdProducto(idProducto);
		    review.setPuntuacion(puntuacion);
		    review.setComentario(comentario);
		    daoStock.guardarResena(review);

		    // Actualizar promedio y cantidad
		    Producto producto = daoStock.recuperarProductoPorId(idProducto);
		    int nuevaCantidad = producto.getCantidadResenas() + 1;
		    double nuevoPromedio = (producto.getPromedioEstrellas() * producto.getCantidadResenas() + puntuacion) / nuevaCantidad;

		    producto.setCantidadResenas(nuevaCantidad);
		    producto.setPromedioEstrellas(nuevoPromedio);
		    daoStock.guardarProducto(producto);
		    
			
				return new ResponseEntity<String>(new Gson().toJson(producto), HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<?> guardarPregunta(String idProducto, String idUsuarioPregunta, String pregunta) {
		try {
			PreguntaRespuesta preguntaRespuesta = new PreguntaRespuesta();
		    preguntaRespuesta.setIdProducto(idProducto);
		    preguntaRespuesta.setIdUsuarioPregunta(idUsuarioPregunta);
		    preguntaRespuesta.setPregunta(pregunta);
		    preguntaRespuesta.setEstado(0); // Sin responder
		    daoStock.guardarPregunta(preguntaRespuesta);
		    
			
				return ResponseEntity.ok(Map.of("code", 200, "message", "Respuesta registrada con éxito"));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(Map.of("code", 500, "message", "Error al guardar la respuesta", "error", e.getMessage()));
		}
	}

	@Override
	public ResponseEntity<?> responderPregunta(int idPregunta, String idUsuarioRespuesta, String respuesta) {
		try {
			PreguntaRespuesta preguntaRespuesta = daoPreguntaRespuesta.findById(idPregunta).orElseThrow();
		    preguntaRespuesta.setRespuesta(respuesta);
		    preguntaRespuesta.setIdUsuarioRespuesta(idUsuarioRespuesta);
		    preguntaRespuesta.setEstado(1); // Respondida
		    preguntaRespuesta.setFechaRespuesta(new Timestamp(System.currentTimeMillis()));
		    daoStock.responderPregunta(preguntaRespuesta);
			
				return ResponseEntity.ok(Map.of("code", 200, "message", "Respuesta registrada con éxito"));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("code", 500, "message", "Error al guardar la respuesta", "error", e.getMessage()));
		}
	}

	@Override
	public ResponseEntity<String> obtenerPreguntasPorProducto(String idProducto) {
		
		try {
            List<PreguntaRespuesta> preguntas = daoPreguntaRespuesta.findByIdProducto(idProducto);
            return new ResponseEntity<String>(new Gson().toJson(preguntas), HttpStatus.OK);
            //return ResponseEntity.ok(Map.of("code", 200, "preguntas", preguntas));
        } catch (Exception e) {
            /*return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("code", 500, "message", "Error al obtener las preguntas", "error", e.getMessage()));*/
			return new ResponseEntity<String>(e.getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);

        }
		
		//return daoPreguntaRespuesta.findByIdProducto(idProducto);
	}

	@Override
	public ResponseEntity<String> obtenerProductosRelacionados(int idTipoProducto, int idCategoriaProducto) {
		try {
            List<Producto> preguntas = daoStock.listadoProductosRelacionados(idTipoProducto, idCategoriaProducto);
            return new ResponseEntity<String>(new Gson().toJson(preguntas), HttpStatus.OK);
            //return ResponseEntity.ok(Map.of("code", 200, "preguntas", preguntas));
        } catch (Exception e) {
            /*return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("code", 500, "message", "Error al obtener las preguntas", "error", e.getMessage()));*/
			return new ResponseEntity<String>(e.getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);

        }
	}

	

}
