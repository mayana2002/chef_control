package com.sena.chef_control.repositorios;

import com.sena.chef_control.entidades.Proveedor;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProveedorRepositorio extends JpaRepository<Proveedor, Integer> {

    @Query("SELECT u FROM Proveedor u JOIN FETCH u.idEstado r")
    List<Proveedor> listarTodosProveedoresRepositorio();

    @Modifying
    @Transactional
    @Query("UPDATE Proveedor p SET p.idEstado.idEstado = :nuevoEstado WHERE p.idProveedor = :proveedorId")
    void cambiarEstadoProveedorRepositorio(@Param("proveedorId") int proveedorId, @Param("nuevoEstado") int nuevoEstado);
}