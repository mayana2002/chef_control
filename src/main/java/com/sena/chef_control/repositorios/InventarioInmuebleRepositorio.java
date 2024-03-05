package com.sena.chef_control.repositorios;

import com.sena.chef_control.entidades.InventarioInmueble;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventarioInmuebleRepositorio extends JpaRepository<InventarioInmueble, Integer> {
}