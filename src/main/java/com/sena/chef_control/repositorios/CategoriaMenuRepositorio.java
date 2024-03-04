package com.sena.chef_control.repositorios;

import com.sena.chef_control.entidades.CategoriaMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaMenuRepositorio extends JpaRepository<CategoriaMenu, Integer> { }