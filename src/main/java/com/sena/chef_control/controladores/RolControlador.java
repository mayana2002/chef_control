package com.sena.chef_control.controladores;

import com.sena.chef_control.entidades.Rol;
import com.sena.chef_control.servicios.RolServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolControlador {

    @Autowired
    private RolServicio rolServicio;

    @GetMapping
    public ResponseEntity<List<Rol>> listarInformacionRolControlador() {
        return ResponseEntity.ok(rolServicio.listarInformacionRol());
    }
}