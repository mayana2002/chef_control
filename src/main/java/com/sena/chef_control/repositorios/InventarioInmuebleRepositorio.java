package com.sena.chef_control.repositorios;

import com.sena.chef_control.entidades.InventarioInmueble;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventarioInmuebleRepositorio extends JpaRepository<InventarioInmueble, Integer> {

    @Query("SELECT u FROM InventarioInmueble u JOIN FETCH u.numeroDocumento e JOIN FETCH u.idEstado r")
    List<InventarioInmueble> listarTodosInmueblesRepositorio();

    @Query("SELECT u FROM InventarioInmueble u JOIN FETCH u.numeroDocumento e JOIN FETCH u.idEstado r WHERE u.idInventarioInmueble = :idInventarioInmueble")
    InventarioInmueble listarInmuebleIdRepositorio(@Param("idInventarioInmueble") int idInventarioInmueble);
}