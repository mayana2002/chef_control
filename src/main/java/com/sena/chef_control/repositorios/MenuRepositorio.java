package com.sena.chef_control.repositorios;

import com.sena.chef_control.entidades.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepositorio extends JpaRepository<Menu, Integer> {
    @Query("SELECT u FROM Menu u JOIN FETCH u.idCategoriaMenu e JOIN FETCH u.idEstado td WHERE td.idEstado = 1")
    List<Menu> listarTodoMenuRepositorio();

    @Query("SELECT u FROM Menu u JOIN FETCH u.idCategoriaMenu e JOIN FETCH u.idEstado td WHERE td.idEstado = 1 AND u.idMenu = :idMenu")
    Menu listarMenuIdRepositorio(@Param("idMenu") int idMenu);
}