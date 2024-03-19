package com.sena.chef_control.repositorios;

import com.sena.chef_control.entidades.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepositorio extends JpaRepository<Menu, Integer> {
    @Query("SELECT u FROM Menu u JOIN FETCH u.idCategoriaMenu e JOIN FETCH u.idEstado td")
    List<Menu> listarTodoMenuRepositorio();

    @Query("SELECT u FROM Menu u JOIN FETCH u.idCategoriaMenu e JOIN FETCH u.idEstado td WHERE u.idMenu = :idMenu")
    Menu listarMenuIdRepositorio(@Param("idMenu") int idMenu);

    @Query("SELECT DISTINCT m FROM Menu m JOIN FETCH m.idCategoriaMenu c JOIN FETCH m.idEstado e WHERE m.nombreMenu LIKE %:nombre%")
    List<Menu> listarCategoriaNombreRepositorio(@Param("nombre") String nombre);
}