package com.ayalait.stock.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.ayalait.stock.service.*;

@RestController
public class ParametroProductosController {

	@Autowired
	ParametrosProductoService service;

	@GetMapping(value = "parametros/categoria", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> listadoDeCategorias() throws Exception {
		return service.obtenerCategorias();

	}
	
	@GetMapping(value = "parametros/modelos", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> listadoModelos() throws Exception {
		return service.modelosProducto();

	}
	
	@GetMapping(value = "parametros/marcas", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> listadoMarcas() throws Exception {
		return service.marcasProducto();

	}

	@GetMapping(value = "parametros/um", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> listadoDeUnidadMedida() throws Exception {
		return service.obtenerUM();

	}

	@GetMapping(value = "parametros/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> obtenerClientePorID(@RequestParam("ci") String ci) throws Exception {

		return service.obtenerClientePorCI(ci);

	}
	
	@GetMapping(value = "parametros/clientes/id", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> obtenerClientePorIDNew(@RequestParam("id") String id) throws Exception {

		return service.obtenerClientePorId(id);

	}

	@GetMapping(value = "parametros/plazos", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> listadoPlazos() throws Exception {
		return service.obtenerPlazos();

	}

	@GetMapping(value = "parametros/moneda/defecto", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> obtenerMonedaFececto() throws Exception {

		return service.valorDefectoMoneda();

	}

	@GetMapping(value = "parametros/tipoproducto", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> listadoTipoProductos() throws Exception {

		return service.obtenerTiposProductos();

	}

	@GetMapping(value = "parametros/impuesto", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> listadoDeImpuestos() throws Exception {

		return service.obtenerImpuesto();

	}

}
