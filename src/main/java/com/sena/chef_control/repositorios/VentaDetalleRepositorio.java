package com.sena.chef_control.repositorios;

import com.sena.chef_control.entidades.VentaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaDetalleRepositorio extends JpaRepository<VentaDetalle, Integer> {
    @Modifying
    @Query("UPDATE VentaDetalle v SET v.cantidadMenu = :nuevaCantidad WHERE v.idVentaDetalle = :idVentaDetalle")
    void actualizarCantidadMenuRepositorio(@Param("idVentaDetalle") int idVentaDetalle, @Param("nuevaCantidad") int nuevaCantidad);
}