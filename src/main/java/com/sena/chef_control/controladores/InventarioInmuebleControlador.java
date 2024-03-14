package com.sena.chef_control.controladores;

import com.sena.chef_control.dto.InventarioInmuebleSolicitud;
import com.sena.chef_control.entidades.Estado;
import com.sena.chef_control.entidades.InventarioInmueble;
import com.sena.chef_control.entidades.Usuario;
import com.sena.chef_control.servicios.InventarioInmuebleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventario-inmueble")
public class InventarioInmuebleControlador {

    @Autowired
    private InventarioInmuebleService inventarioInmuebleService;

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
    public ResponseEntity<List<InventarioInmueble>> listarTodosInmueblesControlador() {
        return ResponseEntity.ok(inventarioInmuebleService.listarTodosInmueblesService());
    }
}