package com.sena.chef_control.repositorios;

import com.sena.chef_control.entidades.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VentaRepositorio extends JpaRepository<Venta, Integer> {

    @Query("SELECT v FROM Venta v WHERE v.fechaVenta BETWEEN :fechaInicial AND :fechaFinal")
    List<Venta> listarVentaFechasRepositorio(@Param("fechaInicial") LocalDateTime fechaInicial, @Param("fechaFinal") LocalDateTime fechaFinal);
}