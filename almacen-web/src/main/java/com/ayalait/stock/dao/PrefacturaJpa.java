package com.ayalait.stock.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ayalait.stock.modelo.*;

public interface PrefacturaJpa extends JpaRepository<Prefactura, String>{

    //SELECT id_orden_compra from ordenes_de_compras  WHERE id_usuario ='8fe25c3e-a8c8-48a5-943e-b0e94cd11db5' AND fecha_hora=
    @Query(value="SELECT id_prefactura from prefacturas  WHERE id_usuario =:id AND fecha_hora=:fecha AND fecha_baja IS null", nativeQuery=true)
    String numeroPrefacturaADD(@Param("id") String id, @Param("fecha") String fecha);
    
    @Query(value="SELECT oc.id_prefactura, DATE_FORMAT(oc.fecha_hora, '%d-%m-%Y')   as fecha, p.descripcion as plazo,m.moneda as moneda, (select COUNT(*) \r\n"
    		+ "		from prefactura_detalle where id_prefactura=oc.id_prefactura) as items, e.descripcion as estado, e.id_orden_compra_estado as id_estado, \r\n"
    		+ "		CONCAT(emp.nombre,' ',emp.apellidos) nombre, cli.nombres as cliente, cli.id_cliente ,oc.cod_factura   \r\n"
    		+ "		FROM plazos p, moneda m, ordenes_de_compras_estados e,usuarios u,empleado emp,prefacturas oc\r\n"
    		+ "		left join clientes cli on oc.id_cliente=cli.id_cliente WHERE oc.id_plazo=p.id_plazo and oc.id_moneda = m.id \r\n"
    		+ "	and e.id_orden_compra_estado = oc.estado and u.idusuario=oc.id_usuario and oc.fecha_baja is NULL AND emp.idempleado=u.idempleado order by id_prefactura desc", nativeQuery=true)
    List<Object> findPrefactura();
    
    @Transactional
    @Modifying
    @Query(value="UPDATE prefacturas SET estado = 6 WHERE id_prefactura =:id", nativeQuery=true)
    int confirmarPedido(@Param("id") String id);
}
