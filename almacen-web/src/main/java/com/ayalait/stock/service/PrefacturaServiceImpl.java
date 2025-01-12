package com.ayalait.stock.service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import com.ayalait.stock.modelo.*;
import com.ayalait.stock.dao.*;
import com.ayalait.utils.ErrorState;
import com.ayalait.utils.OCAprobadas;
import com.ayalait.utils.ResponsePrefactura;

@Service
public class PrefacturaServiceImpl implements PrefacturaService {

	private static final String RESULTADO_OK = "Datos guardado ok.";
	public static final String DELETE_OK="Registro eliminado correctamente.";
	public static final String DELETE_NOK="El registro no existe.";
	public static final String ITEMS_OK="Producto agregado.";
	
	@Autowired
	PrefacturaDao daoPrefactura;

	ErrorState error= new ErrorState();

	
	@Override
	public ResponseEntity<String> crearPrefactura(String pre) {
		try {
			Prefactura request = new Gson().fromJson(pre, Prefactura.class);
			daoPrefactura.crearPrefactura(request);
			return new ResponseEntity<String>(RESULTADO_OK,HttpStatus.OK);
		} catch (Exception e) {
			error.setCode(90020);
			error.setMenssage(e.getCause().getMessage());
			return new ResponseEntity<String>(new Gson().toJson(error),HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<String> obtenerPrefacturaPorId(String id) {
		try {
			Prefactura orden=daoPrefactura.obtenerPrefacturaPorId(id);
			if(orden!=null) {
				return new ResponseEntity<String>(new Gson().toJson(orden), HttpStatus.OK);
			}else {
				error.setCode(9000);
				error.setMenssage("No existen la prefactura con id: "+id);
				return new ResponseEntity<String>(new Gson().toJson(error), HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {
			error.setCode(9010);
			error.setMenssage(e.getCause().getMessage());
			return new ResponseEntity<String>(new Gson().toJson(error), HttpStatus.NOT_ACCEPTABLE);

		}
	}

	@Override
	public ResponseEntity<String> guardarDetallePrefactura(String detalle) {
		try {
			PrefacturaDetalle request = new Gson().fromJson(detalle, PrefacturaDetalle.class);
			daoPrefactura.guardarDetallePrefactura(request);
			return new ResponseEntity<String>(ITEMS_OK,HttpStatus.OK);
		} catch (Exception e) {
			error.setCode(90020);
			error.setMenssage(e.getCause().getCause().getMessage());
			return new ResponseEntity<String>(new Gson().toJson(error),HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<String> eliminarDetallePrefactura(int id) {
		try {
			if(daoPrefactura.recuperarDetallePrefacturaID(id)!=null) {
				daoPrefactura.eliminarDetallePrefcatura(id);
				return new ResponseEntity<String>(DELETE_OK,HttpStatus.OK);
			}
			error.setCode(90002);
			error.setMenssage(DELETE_NOK);
			return new ResponseEntity<String>(new Gson().toJson(error),HttpStatus.BAD_REQUEST);

		} catch (Exception e) {
			error.setCode(90020);
			error.setMenssage(e.getCause().getCause().getMessage());
			return new ResponseEntity<String>(new Gson().toJson(error),HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<String> obtenerNumeroPrefactura(String fecha, String idUsuario) {
		try {
			String resultado= daoPrefactura.obtenerNumeroPrefactura(fecha, idUsuario);
			return new ResponseEntity<String>(String.valueOf(resultado),HttpStatus.OK);
			
		} catch (Exception e) {
			error.setCode(90020);
			error.setMenssage(e.getCause().getMessage());
			return new ResponseEntity<String>(new Gson().toJson(error),HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<String> listadoPrefacturas() {
		try {
			Iterator<Object> lst = daoPrefactura.listadoPrefactura().iterator();
			List<ResponsePrefactura> lstPrefact= new ArrayList<ResponsePrefactura>();
			if(lst != null && lst.hasNext()) {
				while( lst.hasNext()) {
					Object[] objArray = (Object[]) lst.next();
					ResponsePrefactura response= new ResponsePrefactura();
					   response.setId_prefactura(objArray[0].toString());
					   response.setFecha(objArray[1].toString());					  
					   response.setPlazo(objArray[2].toString());
					   response.setId_moneda(objArray[3].toString());
					   response.setItems(objArray[4].toString());
					   response.setEstado(objArray[5].toString());
					   response.setId_estado(objArray[6].toString());
					   response.setNombre(objArray[7].toString());
					   response.setCliente(objArray[8].toString());
					   response.setId_cliente(objArray[9].toString());
					   response.setCod_factura(objArray[10].toString());
					   lstPrefact.add(response);
				}
				// Ordenar la lista por fecha usando un Comparator clásico
		      /*  Collections.sort(lstPrefact, new Comparator<ResponsePrefactura>() {
		            @Override
		            public int compare(ResponsePrefactura r1, ResponsePrefactura r2) {
		                return r1.getFecha().compareTo(r2.getFecha());
		            }
		        });*/
		        
		     // Ordenar la lista por fecha en orden descendente usando una expresión lambda
				Collections.sort(lstPrefact, (r1, r2) -> r1.getFecha().compareTo(r2.getFecha()));

		        
				return new ResponseEntity<String>(new Gson().toJson(lstPrefact),HttpStatus.OK);
			}else {
				error.setCode(90002);
				error.setMenssage("No hay registros de prefacturas.");
				return new ResponseEntity<String>(new Gson().toJson(error),HttpStatus.BAD_GATEWAY);
			}
		} catch (Exception e) {
			error.setCode(90020);
			error.setMenssage(e.getCause().getMessage());
			return new ResponseEntity<String>(new Gson().toJson(error),HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	
	

	@Override
	public ResponseEntity<String> salvarModificaciones(String datos) {
		try {
			PrefacturaModificaciones request = new Gson().fromJson(datos, PrefacturaModificaciones.class);
			daoPrefactura.guardarModificacionPrefactura(request);
			return new ResponseEntity<String>(RESULTADO_OK,HttpStatus.OK);
		} catch (Exception e) {
			error.setCode(90020);
			error.setMenssage(e.getCause().getMessage());
			return new ResponseEntity<String>(new Gson().toJson(error),HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<String> listadoPrefacturasAprobadas() {
		try {
			Iterator<Object> lst = daoPrefactura.listadoPrefacturasAprobadas().iterator();
			List<OCAprobadas> lstPrefact= new ArrayList<OCAprobadas>();
			if(lst != null && lst.hasNext()) {
				while( lst.hasNext()) {
					Object[] objArray = (Object[]) lst.next();
					 OCAprobadas items = new OCAprobadas();
					   items.setId(objArray[0].toString()) ;
					   items.setNombre(objArray[1].toString());
					   lstPrefact.add(items);
				}
				return new ResponseEntity<String>(new Gson().toJson(lstPrefact),HttpStatus.OK);
			}else {
				error.setCode(90002);
				error.setMenssage("No hay registros de modificación en prefacturas.");
				return new ResponseEntity<String>(new Gson().toJson(error),HttpStatus.BAD_GATEWAY);
			}
		} catch (Exception e) {
			error.setCode(90020);
			error.setMenssage(e.getCause().getMessage());
			return new ResponseEntity<String>(new Gson().toJson(error),HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<String> obtenerModificacionPrefacturaId(int idPrefactura) {
		try {
			PrefacturaModificaciones response= daoPrefactura.obtenerModificacionPrefacturaId(idPrefactura);
			if(response!=null) {
				return new ResponseEntity<String>(new Gson().toJson(response),HttpStatus.OK);

			}else {
				error.setCode(90004);
				error.setMenssage("No se encontraron actualizaciones de la prefactura #: "+ idPrefactura);
				return new ResponseEntity<String>(new Gson().toJson(error),HttpStatus.BAD_GATEWAY);

			}
			
		} catch (Exception e) {
			error.setCode(90020);
			error.setMenssage(e.getCause().getMessage());
			return new ResponseEntity<String>(new Gson().toJson(error),HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<String> obtenerClientePorID(String idCliente) {
		try {
			Cliente response= daoPrefactura.obtenerClientePorID(idCliente);
			if(response!=null) {
				return new ResponseEntity<String>(new Gson().toJson(response),HttpStatus.OK);

			}else {
				error.setCode(90004);
				error.setMenssage("No se encontraro al cliente con id: "+ idCliente);
				return new ResponseEntity<String>(new Gson().toJson(error),HttpStatus.BAD_GATEWAY);

			}
			
		} catch (Exception e) {
			error.setCode(90020);
			error.setMenssage(e.getCause().getMessage());
			return new ResponseEntity<String>(new Gson().toJson(error),HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public String confirmarPedido(String idPedido) {
		try {
			int response= daoPrefactura.confirmarPedido(idPedido);
			if(response>0) {
				return "<html lang=\"en\">\r\n"
						+ "<head>\r\n"
						+ "    <meta charset=\"UTF-8\">\r\n"
						+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
						+ "    <title>Confirmación Exitosa</title>\r\n"
						+ "    <style>\r\n"
						+ "        body {\r\n"
						+ "            font-family: Arial, sans-serif;\r\n"
						+ "            margin: 20px;\r\n"
						+ "            text-align: center;\r\n"
						+ "            background-color: #f3f3f3;\r\n"
						+ "        }\r\n"
						+ "        .container {\r\n"
						+ "            max-width: 600px;\r\n"
						+ "            margin: 0 auto;\r\n"
						+ "            padding: 20px;\r\n"
						+ "            border-radius: 5px;\r\n"
						+ "            background-color: #ffffff;\r\n"
						+ "            box-shadow: 0 2px 4px rgba(0,0,0,0.1);\r\n"
						+ "        }\r\n"
						+ "        .icon {\r\n"
						+ "            font-size: 60px;\r\n"
						+ "            color: #28a745;\r\n"
						+ "        }\r\n"
						+ "        h2 {\r\n"
						+ "            color: #28a745;\r\n"
						+ "            margin-bottom: 10px;\r\n"
						+ "        }\r\n"
						+ "        p {\r\n"
						+ "            margin-bottom: 20px;\r\n"
						+ "        }\r\n"
						+ "        .btn {\r\n"
						+ "            display: inline-block;\r\n"
						+ "            font-weight: 400;\r\n"
						+ "            color: #ffffff;\r\n"
						+ "            text-align: center;\r\n"
						+ "            vertical-align: middle;\r\n"
						+ "            user-select: none;\r\n"
						+ "            background-color: #007bff;\r\n"
						+ "            border: 1px solid transparent;\r\n"
						+ "            padding: 10px 20px;\r\n"
						+ "            font-size: 1rem;\r\n"
						+ "            line-height: 1.5;\r\n"
						+ "            border-radius: 5px;\r\n"
						+ "            text-decoration: none;\r\n"
						+ "        }\r\n"
						+ "        .btn:hover {\r\n"
						+ "            background-color: #0056b3;\r\n"
						+ "            color: #ffffff;\r\n"
						+ "        }\r\n"
						+ "    </style>\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "    <div class=\"container\">\r\n"
						+ "        <span class=\"icon\">&#10003;</span>\r\n"
						+ "        <h2>Confirmación Exitosa</h2>\r\n"
						+ "        <p>Su pedido ha sido confirmado con éxito. ¡Gracias por su pedido!</p>\r\n"
						+ "        <p>Detalles del pedido:</p>\r\n"
						+ "        <ul>\r\n"
						+ "            <li><strong>Número de Pedido:</strong> 123456789</li>\r\n"
						+ "            <li><strong>Fecha:</strong> 15 de Abril, 2024</li>\r\n"
						+ "            <li><strong>Total:</strong> $500.00 USD</li>\r\n"
						+ "        </ul>\r\n"
						+ "        <p><a class=\"btn\" href=\"https://ayalait.com.uy\" target=\"_blank\">Volver al Sitio Web</a></p>\r\n"
						+ "    </div>\r\n"
						+ "</body>\r\n"
						+ "</html>\r\n"
						+ "";

			}else {
				error.setCode(90004);
				error.setMenssage("Ocurrio un error actualizando su pedido.");
				return "<!DOCTYPE html>\r\n"
						+ "<html lang=\"en\">\r\n"
						+ "<head>\r\n"
						+ "    <meta charset=\"UTF-8\">\r\n"
						+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
						+ "    <title>No Confirmación de Pedido</title>\r\n"
						+ "    <style>\r\n"
						+ "        body {\r\n"
						+ "            font-family: Arial, sans-serif;\r\n"
						+ "            margin: 20px;\r\n"
						+ "            text-align: center;\r\n"
						+ "            background-color: #f3f3f3;\r\n"
						+ "        }\r\n"
						+ "        .container {\r\n"
						+ "            max-width: 600px;\r\n"
						+ "            margin: 0 auto;\r\n"
						+ "            padding: 20px;\r\n"
						+ "            border-radius: 5px;\r\n"
						+ "            background-color: #ffffff;\r\n"
						+ "            box-shadow: 0 2px 4px rgba(0,0,0,0.1);\r\n"
						+ "        }\r\n"
						+ "        .icon {\r\n"
						+ "            font-size: 60px;\r\n"
						+ "            color: #dc3545;\r\n"
						+ "        }\r\n"
						+ "        h2 {\r\n"
						+ "            color: #dc3545;\r\n"
						+ "            margin-bottom: 10px;\r\n"
						+ "        }\r\n"
						+ "        p {\r\n"
						+ "            margin-bottom: 20px;\r\n"
						+ "        }\r\n"
						+ "        .btn {\r\n"
						+ "            display: inline-block;\r\n"
						+ "            font-weight: 400;\r\n"
						+ "            color: #ffffff;\r\n"
						+ "            text-align: center;\r\n"
						+ "            vertical-align: middle;\r\n"
						+ "            user-select: none;\r\n"
						+ "            background-color: #007bff;\r\n"
						+ "            border: 1px solid transparent;\r\n"
						+ "            padding: 10px 20px;\r\n"
						+ "            font-size: 1rem;\r\n"
						+ "            line-height: 1.5;\r\n"
						+ "            border-radius: 5px;\r\n"
						+ "            text-decoration: none;\r\n"
						+ "        }\r\n"
						+ "        .btn:hover {\r\n"
						+ "            background-color: #0056b3;\r\n"
						+ "            color: #ffffff;\r\n"
						+ "        }\r\n"
						+ "    </style>\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "    <div class=\"container\">\r\n"
						+ "        <span class=\"icon\">&#10060;</span>\r\n"
						+ "        <h2>No se pudo Confirmar el Pedido</h2>\r\n"
						+ "        <p>Lamentablemente, no se ha podido confirmar su pedido en este momento.</p>\r\n"
						+ "        <p>Si tiene alguna pregunta o necesita asistencia, por favor contáctenos.</p>\r\n"
						+ "        <p>Gracias por su comprensión.</p>\r\n"
						+ "        <p><a class=\"btn\" href=\"https://ayalait.com.uy/contactanos/\" target=\"_blank\">Contactar Soporte</a></p>\r\n"
						+ "    </div>\r\n"
						+ "</body>\r\n"
						+ "</html>\r\n"
						+ "";

			}
			
		} catch (Exception e) {
			error.setCode(90020);
			error.setMenssage(e.getCause().getMessage());
			return "<!DOCTYPE html>\r\n"
					+ "<html lang=\"en\">\r\n"
					+ "<head>\r\n"
					+ "    <meta charset=\"UTF-8\">\r\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "    <title>No Confirmación de Pedido</title>\r\n"
					+ "    <style>\r\n"
					+ "        body {\r\n"
					+ "            font-family: Arial, sans-serif;\r\n"
					+ "            margin: 20px;\r\n"
					+ "            text-align: center;\r\n"
					+ "            background-color: #f3f3f3;\r\n"
					+ "        }\r\n"
					+ "        .container {\r\n"
					+ "            max-width: 600px;\r\n"
					+ "            margin: 0 auto;\r\n"
					+ "            padding: 20px;\r\n"
					+ "            border-radius: 5px;\r\n"
					+ "            background-color: #ffffff;\r\n"
					+ "            box-shadow: 0 2px 4px rgba(0,0,0,0.1);\r\n"
					+ "        }\r\n"
					+ "        .icon {\r\n"
					+ "            font-size: 60px;\r\n"
					+ "            color: #dc3545;\r\n"
					+ "        }\r\n"
					+ "        h2 {\r\n"
					+ "            color: #dc3545;\r\n"
					+ "            margin-bottom: 10px;\r\n"
					+ "        }\r\n"
					+ "        p {\r\n"
					+ "            margin-bottom: 20px;\r\n"
					+ "        }\r\n"
					+ "        .btn {\r\n"
					+ "            display: inline-block;\r\n"
					+ "            font-weight: 400;\r\n"
					+ "            color: #ffffff;\r\n"
					+ "            text-align: center;\r\n"
					+ "            vertical-align: middle;\r\n"
					+ "            user-select: none;\r\n"
					+ "            background-color: #007bff;\r\n"
					+ "            border: 1px solid transparent;\r\n"
					+ "            padding: 10px 20px;\r\n"
					+ "            font-size: 1rem;\r\n"
					+ "            line-height: 1.5;\r\n"
					+ "            border-radius: 5px;\r\n"
					+ "            text-decoration: none;\r\n"
					+ "        }\r\n"
					+ "        .btn:hover {\r\n"
					+ "            background-color: #0056b3;\r\n"
					+ "            color: #ffffff;\r\n"
					+ "        }\r\n"
					+ "    </style>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "    <div class=\"container\">\r\n"
					+ "        <span class=\"icon\">&#10060;</span>\r\n"
					+ "        <h2>No se pudo Confirmar el Pedido</h2>\r\n"
					+ "        <p>Lamentablemente, no se ha podido confirmar su pedido en este momento.</p>\r\n"
					+ "        <p>Si tiene alguna pregunta o necesita asistencia, por favor contáctenos.</p>\r\n"
					+ "        <p>Gracias por su comprensión.</p>\r\n"
					+ "        <p><a class=\"btn\" href=\"https://ayalait.com.uy/contactanos\" target=\"_blank\">Contactar Soporte</a></p>\r\n"
					+ "    </div>\r\n"
					+ "</body>\r\n"
					+ "</html>\r\n"
					+ "";
		}
	}

	

}
