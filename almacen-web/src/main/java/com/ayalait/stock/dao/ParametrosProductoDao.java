package com.ayalait.stock.dao;


import java.util.List;

import org.springframework.stereotype.Component;

import com.ayalait.stock.modelo.*;

@Component
public interface ParametrosProductoDao {
	
	
	//Tipo de productos
	List<TipoProducto> obtenerTipoProductos();
	
	//Categorias de productos
	List<Categoria> obtenerCategoriasProductos();
	
	//Listado de UM
	List<UnidadMedida> obtenerUM();
	
	//Listado de impuesto
	List<Impuesto> obtenerImpuestos();
	
	
	//FormasPagos
	List<FormasPago> obtenerFormasPagos();
	
	//Plazos
	List<Plazos> obtenerPlazos();
	
	//Proveedores
	Proveedor obtenerProveedorPorID(int id);
	
	//Despositos
	List<Depositos> obtenerDepositos();	
	
	
	//Formas de cobros
	List<FormasCobro> listaFormasCobro();
	
	//Clientes
	Cliente obtenerClientePorCI(String ci);
	Cliente obtenerClientePorId(String id);
	
	//Lista de monedas
	List<Moneda> obtenerMonedas();
	
	//Moneda por defecto
	int obtenerMonedaDefecto();
	
	//Lista de marcas
	List<MarcaProducto> obtenerMarcas();
	
	//Lista de modelos
	List<ModeloProducto> obtenerModelos();
		
	
	 

	
}
