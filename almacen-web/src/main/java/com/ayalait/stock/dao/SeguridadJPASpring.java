package com.ayalait.stock.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ayalait.stock.modelo.*;




public interface SeguridadJPASpring extends JpaRepository <Seguridad, String> {


}
