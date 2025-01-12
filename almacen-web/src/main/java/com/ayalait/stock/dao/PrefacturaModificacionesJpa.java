package com.ayalait.stock.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ayalait.stock.modelo.*;


public interface PrefacturaModificacionesJpa extends JpaRepository<PrefacturaModificaciones, Integer>{
	
	@Query(value="SELECT om.id_prefactura, CONCAT(e.nombre,' ',e.apellidos) nombre from usuarios u join prefacturas_modificaciones om\r\n"
			+ "on(u.idusuario=om.id_usuario_autorizo) JOIN empleado e ON(e.idempleado=u.idempleado);", nativeQuery=true)
    List<Object> findPrefacturaModificadas();
	
	@Query(value="SELECT * FROM gesventas_test.prefacturas_modificaciones p where p.id_prefactura=:id ", nativeQuery=true)
   PrefacturaModificaciones findById_usuario_cancela(int id);
}
