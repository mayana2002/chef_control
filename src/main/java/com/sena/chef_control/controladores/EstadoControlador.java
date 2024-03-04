package com.sena.chef_control.controladores;

import com.sena.chef_control.entidades.Estado;
import com.sena.chef_control.servicios.EstadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoControlador {

    @Autowired
    private EstadoServicio estadoServicio;

    @GetMapping
    public ResponseEntity<List<Estado>> listarInformacionEstadosControlador() {
        return ResponseEntity.ok(estadoServicio.listarInformacionEstados());
    }
}