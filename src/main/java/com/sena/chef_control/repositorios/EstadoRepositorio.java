package com.sena.chef_control.repositorios;

import com.sena.chef_control.entidades.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepositorio extends JpaRepository<Estado, Integer> { }