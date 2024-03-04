package com.sena.chef_control.controladores;

import com.sena.chef_control.entidades.Proveedor;
import com.sena.chef_control.servicios.ProveedorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedores")
public class ProveedorControlador {

    @Autowired
    private ProveedorServicio proveedorServicio;

    @PostMapping("/crear")
    public ResponseEntity<Proveedor> registrarProveedorControlador(@RequestBody Proveedor proveedor) {
        return ResponseEntity.ok(proveedorServicio.registarProveedor(proveedor));
    }

    @GetMapping
    public ResponseEntity<List<Proveedor>> listarTodosProveedoresControlador() {
        return ResponseEntity.ok(proveedorServicio.listarTodosProveedoresServicio());
    }

    @PutMapping("/cambiar-estado/{idProveedor}/{idEstado}")
    public void cambiarEstadoProveedorService(@PathVariable int idProveedor, @PathVariable int idEstado) {
        proveedorServicio.cambiarEstadoProveedorService(idProveedor, idEstado);
    }
}