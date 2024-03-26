package com.sena.chef_control.controladores;

import com.sena.chef_control.dto.RespuestaPreguntaValidacion;
import com.sena.chef_control.entidades.RespuestaPregunta;
import com.sena.chef_control.servicios.RespuestaPreguntaServicio;
import com.sena.chef_control.utilidad.JwtUtilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/respuesta-pregunta")
public class RespuestaPreguntaControlador {

    @Autowired
    private RespuestaPreguntaServicio respuestaPreguntaServicio;

    @Autowired
    private JwtUtilidad jwtUtilidad;

    @GetMapping
    public ResponseEntity<List<RespuestaPregunta>> listarRespuestaPreguntaControlador(@RequestHeader("Authorization") String token) {
        if (token == null || !token.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String jwtToken = token.substring(7); // Eliminar "Bearer " del token

        if (!jwtUtilidad.validateToken(jwtToken)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(respuestaPreguntaServicio.listarRespuestaPregunta());
    }

    @PostMapping("/validacion")
    public ResponseEntity<RespuestaPregunta> listarRespuestaPorPreguntaControlador(@RequestBody RespuestaPreguntaValidacion respuestaPreguntaValidacion,@RequestHeader("Authorization") String token) {
        if (token == null || !token.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String jwtToken = token.substring(7); // Eliminar "Bearer " del token

        if (!jwtUtilidad.validateToken(jwtToken)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(respuestaPreguntaServicio.listarRespuestaPorPreguntaServicio(respuestaPreguntaValidacion.getDescripcionRespuesta(), respuestaPreguntaValidacion.getIdPregunta()));
    }
}