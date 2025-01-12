package com.ayalait.stock.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.ayalait.stock.modelo.*;

@Repository
public class ParametrosProductoImpl implements ParametrosProductoDao {

	@Autowired
	MonedaJPASpring daoMoneda;

	@Autowired
	SucursalJPASpring daoSucursal;

	@Autowired
	TipoProductoJpaSpring daoTipoProd;

	@Autowired
	CategoriaJpaSpring daoCategoria;

	@Autowired
	UMJpaSpring daoUM;

	@Autowired
	ImpuestoJpaSpring daoIVA;

	@Autowired
	FormasPagoJpaSpring daoFormaPago;

	@Autowired
	PlazosJpaSpring daoPlazos;

	@Autowired
	ProveedorlJPASpring daoProveedor;

	@Autowired
	DepositosJpaSpring daoDeposito;

	@Autowired
	FormaCobroJpaSpring daoFormaCobro;

	@Autowired
	ClienteJpaSpring daoCliente;
	
	@Autowired
	MarcaProductoJpaSpring daoMarca;
	
	@Autowired
	ModeloProductoJpaSpring daoModelo;

	@Override
	public List<TipoProducto> obtenerTipoProductos() {

		return daoTipoProd.findAll().stream().filter(e -> e.getEstado()==1).toList();
	}

	@Override
	public List<Categoria> obtenerCategoriasProductos() {

		return daoCategoria.findAll().stream().filter(e -> e.getEstado()==1).toList();
	}

	@Override
	public List<UnidadMedida> obtenerUM() {

		return daoUM.findAll();
	}

	@Override
	public List<Impuesto> obtenerImpuestos() {

		return daoIVA.findAll();
	}

	@Override
	public List<FormasPago> obtenerFormasPagos() {

		return daoFormaPago.findAll();
	}

	@Override
	public List<Plazos> obtenerPlazos() {

		return daoPlazos.findAll();
	}

	@Override
	public Proveedor obtenerProveedorPorID(int id) {
		return daoProveedor.findById(id).orElse(null);
	}

	@Override
	public List<Depositos> obtenerDepositos() {
		return daoDeposito.findAll();
	}

	@Override
	public List<FormasCobro> listaFormasCobro() {
		return daoFormaCobro.findAll();
	}

	@Override
	public Cliente obtenerClientePorCI(String ci) {
		return daoCliente.buscarClientePorCI(ci);
	}

	@Override
	public List<Moneda> obtenerMonedas() {
		return daoMoneda.findAll();
	}

	@Override
	public int obtenerMonedaDefecto() {
		return daoMoneda.buscaridMonedaDefault();
	}

	@Override
	public List<MarcaProducto> obtenerMarcas() {
		return daoMarca.findAll().stream().filter(e -> e.getEstado()==1).toList();
	}

	@Override
	public List<ModeloProducto> obtenerModelos() {
		return daoModelo.findAll().stream().filter(e -> e.getEstado()==1).toList();
	}

	@Override
	public Cliente obtenerClientePorId(String id) {		
		return daoCliente.findById(id).orElse(null);
	}

}
