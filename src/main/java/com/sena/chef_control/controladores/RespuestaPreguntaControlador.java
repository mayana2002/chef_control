package com.sena.chef_control.controladores;

import com.sena.chef_control.entidades.RespuestaPregunta;
import com.sena.chef_control.servicios.RespuestaPreguntaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/respuesta-pregunta")
public class RespuestaPreguntaControlador {

    @Autowired
    private RespuestaPreguntaServicio respuestaPreguntaServicio;

    @GetMapping
    public ResponseEntity<List<RespuestaPregunta>> listarRespuestaPreguntaControlador() {
        return ResponseEntity.ok(respuestaPreguntaServicio.listarRespuestaPregunta());
    }
}