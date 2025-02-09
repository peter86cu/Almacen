package com.ayalait.stock.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.ayalait.stock.modelo.*;


public interface ShoppingCartJpaSpring extends JpaRepository<ShoppingCart, String>{
	
	ShoppingCart findByIdcartAndIdusuario(String idcart, String idusuario);
	
	//List<ShoppingCart> findByIdusuario1(String idusuario);
	
	@Query(value="SELECT s.* FROM gesventas.shopping_cart s join shopping_cart_detail sd on (s.idcart=sd.idcart) join shopping_estados_venta sev on(sev.id=s.idhistestado) where s.idusuario=:idusuario and sev.idestado=6", nativeQuery=true)
	List<ShoppingCart> findByIdusuario( String idusuario);
	
	  @Procedure(name = "actualizarEstadoCart")
	    void actualizarEstadoCart(@Param("idCart") String inputParam1);
}
