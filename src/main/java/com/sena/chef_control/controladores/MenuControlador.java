package com.sena.chef_control.controladores;

import com.sena.chef_control.dto.MenuSolicitud;
import com.sena.chef_control.entidades.CategoriaMenu;
import com.sena.chef_control.entidades.Estado;
import com.sena.chef_control.entidades.Menu;
import com.sena.chef_control.repositorios.MenuRepositorio;
import com.sena.chef_control.servicios.MenuServicio;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuControlador {

    @Autowired
    private MenuServicio menuServicio;

    @PostMapping
    public ResponseEntity<Menu> crearMenuControlador(@RequestBody MenuSolicitud menuSolicitud) {
        Estado estado = new Estado();
        estado.setIdEstado(1);

        CategoriaMenu categoriaMenu = new CategoriaMenu();
        categoriaMenu.setIdCategoriaMenu(menuSolicitud.getIdCategoriaMenu());

        Menu menu = new Menu();
        menu.setNombreMenu(menuSolicitud.getNombreMenu());
        menu.setDescripcionMenu(menuSolicitud.getDescripcionMenu());
        menu.setPrecioMenu(menuSolicitud.getPrecioMenu());
        menu.setIdEstado(estado);
        menu.setIdCategoriaMenu(categoriaMenu);

        return ResponseEntity.ok(menuServicio.crearMenu(menu));
    }

    @GetMapping
    public ResponseEntity<List<Menu>> listarTodoMenuControlador() {
        return ResponseEntity.ok(menuServicio.listarTodoMenuServicio());
    }
}