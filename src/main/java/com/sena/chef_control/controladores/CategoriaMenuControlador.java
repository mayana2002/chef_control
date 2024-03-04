package com.sena.chef_control.controladores;

import com.sena.chef_control.entidades.CategoriaMenu;
import com.sena.chef_control.servicios.CategoriaMenuServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categorias-menus")
public class CategoriaMenuControlador {

    @Autowired
    private CategoriaMenuServicio categoriaMenuServicio;

    @GetMapping
    public ResponseEntity<List<CategoriaMenu>> listarInformacionCategoriasMenusControlador() {
        return ResponseEntity.ok(categoriaMenuServicio.listarInformacionCategoriasMenus());
    }
}