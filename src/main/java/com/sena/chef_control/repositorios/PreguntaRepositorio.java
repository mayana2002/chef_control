package com.sena.chef_control.repositorios;

import com.sena.chef_control.entidades.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreguntaRepositorio extends JpaRepository<Pregunta, Integer> { }