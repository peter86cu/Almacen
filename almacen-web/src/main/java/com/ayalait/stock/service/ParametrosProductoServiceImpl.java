package com.ayalait.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import com.ayalait.stock.modelo.*;

import com.ayalait.stock.dao.*;

@Service
public class ParametrosProductoServiceImpl implements ParametrosProductoService {

	@Autowired
	ParametrosProductoDao service;

	@Cacheable(cacheNames = "categorias")
	@Override
	public ResponseEntity<String> obtenerCategorias() {
		try {
			List<Categoria> lstCategoria = service.obtenerCategoriasProductos();
			if (!lstCategoria.isEmpty()) {
				return new ResponseEntity<String>(new Gson().toJson(lstCategoria), HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("No existen categorias en la base de datos.", HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
	}

	//@Cacheable(cacheNames = "um")
	@Override
	public ResponseEntity<String> obtenerUM() {

		try {

			List<UnidadMedida> lstUM = service.obtenerUM();
			if (!lstUM.isEmpty()) {
				return new ResponseEntity<String>(new Gson().toJson(lstUM), HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("No existen categorias en la base de datos.", HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
	}
	//@Cacheable(cacheNames="impuesto")
	@Override
	public ResponseEntity<String> obtenerImpuesto() {
		try {
			List<Impuesto> lstIVA = service.obtenerImpuestos();
			if (!lstIVA.isEmpty()) {
				return new ResponseEntity<String>(new Gson().toJson(lstIVA), HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("No existen categorias en la base de datos.", HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);

		}
	}

	//@Cacheable(cacheNames="monedas")
	@Override
	public ResponseEntity<String> obtenerMoneda() {
		try {
			List<Moneda> lstMoneda = service.obtenerMonedas();
			if (!lstMoneda.isEmpty()) {
				return new ResponseEntity<String>(new Gson().toJson(lstMoneda), HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("No existen monedas en la base de datos.", HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
	}

	
	//@Cacheable(cacheNames="plazos")
	@Override
	public ResponseEntity<String> obtenerPlazos() {
		try {
		
			List<Plazos> lstPlazos = service.obtenerPlazos();
			if (!lstPlazos.isEmpty()) {
				return new ResponseEntity<String>(new Gson().toJson(lstPlazos), HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("No existen formas de pagos en la base de datos.",
						HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getMessage(),
					HttpStatus.NOT_ACCEPTABLE);
		}
	}
	//@Cacheable(cacheNames="depositos")
	@Override
	public ResponseEntity<String> obtenerDepositos() {
		try {
			List<Depositos> lstDeposito=service.obtenerDepositos();
			if(!lstDeposito.isEmpty()) {
				return new ResponseEntity<String>(new Gson().toJson(lstDeposito), HttpStatus.OK);
			}else{
				return new ResponseEntity<String>("No existen depositos en la base de datos.",
						HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<String> obtenerClientePorCI(String ci) {
		try {
			Cliente cliente = service.obtenerClientePorCI(ci);
			if (cliente != null) {
				return new ResponseEntity<String>(new Gson().toJson(cliente), HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("No existen clientes en la base de datos.", HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<String> obtenerTiposProductos() {
		try {
			List<TipoProducto> lstTipoProductos=service.obtenerTipoProductos();
			if(!lstTipoProductos.isEmpty()) {
				return new ResponseEntity<String>(new Gson().toJson(lstTipoProductos), HttpStatus.OK);
			}else{
				return new ResponseEntity<String>("No existen tipos de productos en la base de datos.",
						HttpStatus.BAD_REQUEST);
			}	
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
	}

	

	@Override
	public ResponseEntity<String> buscarProveedorPorID(int id) {
		try {
			Proveedor proveedor = service.obtenerProveedorPorID(id);
			if (proveedor != null) {
				return new ResponseEntity<String>(new Gson().toJson(proveedor), HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("No existen el proveedor con id:" + id + " en la base de datos.",
						HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getMessage(),
					HttpStatus.NOT_ACCEPTABLE);
		}
		
	}
	//@Cacheable(cacheNames="defecto")
	@Override
	public ResponseEntity<String> valorDefectoMoneda() {
		try {
			int valora = service.obtenerMonedaDefecto();
			if (valora != 0) {
				return new ResponseEntity<String>(new Gson().toJson(valora), HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("No existe una moneda por defecto", HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	//@Cacheable(cacheNames="marcas")
	@Override
	public ResponseEntity<String> marcasProducto() {
		try {
			List<MarcaProducto> lstMarca = service.obtenerMarcas();
			if (!lstMarca.isEmpty()) {
				return new ResponseEntity<String>(new Gson().toJson(lstMarca), HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("No existen marcas en la base de datos.", HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
	}
	//@Cacheable(cacheNames="modelos")
	@Override
	public ResponseEntity<String> modelosProducto() {
		try {
			List<ModeloProducto> lstModelo = service.obtenerModelos();
			if (!lstModelo.isEmpty()) {
				return new ResponseEntity<String>(new Gson().toJson(lstModelo), HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("No existen modelos en la base de datos.", HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@Override
	public ResponseEntity<String> obtenerClientePorId(String id) {
		try {
			Cliente cliente = service.obtenerClientePorId(id);
			if (cliente != null) {
				return new ResponseEntity<String>(new Gson().toJson(cliente), HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("No existen el cliente con id:" + id + " en la base de datos.",
						HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().getMessage(),
					HttpStatus.NOT_ACCEPTABLE);
		}
	}

}
