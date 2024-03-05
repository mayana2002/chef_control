package com.sena.chef_control.controladores;

import com.sena.chef_control.entidades.Pregunta;
import com.sena.chef_control.servicios.PreguntaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("preguntas")
public class PreguntaControlador {

    @Autowired
    private PreguntaServicio preguntaServicio;

    @GetMapping
    public ResponseEntity<List<Pregunta>> listarPreguntasControlador() {
        return ResponseEntity.ok(preguntaServicio.listarPreguntas());
    }
}