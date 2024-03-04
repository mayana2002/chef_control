package com.sena.chef_control.repositorios;

import com.sena.chef_control.entidades.MedioPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedioPagoRepositorio extends JpaRepository<MedioPago, Integer> { }