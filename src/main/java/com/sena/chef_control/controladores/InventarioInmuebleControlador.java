package com.sena.chef_control.controladores;

import com.sena.chef_control.dto.InventarioInmuebleSolicitud;
import com.sena.chef_control.entidades.Estado;
import com.sena.chef_control.entidades.InventarioInmueble;
import com.sena.chef_control.entidades.Usuario;
import com.sena.chef_control.servicios.InventarioInmuebleService;
import com.sena.chef_control.utilidad.JwtUtilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventario-inmueble")
public class InventarioInmuebleControlador {

    @Autowired
    private InventarioInmuebleService inventarioInmuebleService;

    @Autowired
    private JwtUtilidad jwtUtilidad;

    @PostMapping("/crear")
    public ResponseEntity<InventarioInmueble> registrarInventarioInmuebleCoontrolador(@RequestBody InventarioInmuebleSolicitud inventarioInmuebleSolicitud) {
        Usuario usuario = new Usuario();
        usuario.setNumeroDocumento(inventarioInmuebleSolicitud.getNumeroDocumento());

        Estado estado = new Estado();
        estado.setIdEstado(1);

        InventarioInmueble inventarioInmueble = new InventarioInmueble();
        inventarioInmueble.setNombreInmueble(inventarioInmuebleSolicitud.getNombreInmueble());
        inventarioInmueble.setCantidadInmueble(inventarioInmuebleSolicitud.getCantidadInmueble());
        inventarioInmueble.setDescripcionInmueble(inventarioInmuebleSolicitud.getDescripcionInmueble());
        inventarioInmueble.setNumeroDocumento(usuario);
        inventarioInmueble.setIdEstado(estado);

        return ResponseEntity.ok(inventarioInmuebleService.registrarInventarioInmueble(inventarioInmueble));
    }

    @GetMapping
    public ResponseEntity<List<InventarioInmueble>> listarTodosInmueblesControlador(@RequestHeader("Authorization") String token) {
        if (token == null || !token.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String jwtToken = token.substring(7); // Eliminar "Bearer " del token

        if (!jwtUtilidad.validateToken(jwtToken)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(inventarioInmuebleService.listarTodosInmueblesService());
    }

    @GetMapping("/{idInventarioInmueble}")
    public ResponseEntity<InventarioInmueble> listarInmuebleIdControlador(@RequestHeader("Authorization") String token, @PathVariable int idInventarioInmueble) {
        if (token == null || !token.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String jwtToken = token.substring(7); // Eliminar "Bearer " del token

        if (!jwtUtilidad.validateToken(jwtToken)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(inventarioInmuebleService.listarInmuebleIdServicio(idInventarioInmueble));
    }
}