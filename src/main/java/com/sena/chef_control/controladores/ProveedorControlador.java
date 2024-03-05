package com.sena.chef_control.controladores;

import com.sena.chef_control.dto.ProveedorSolicitud;
import com.sena.chef_control.entidades.Estado;
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
    public ResponseEntity<Proveedor> registrarProveedorControlador(@RequestBody ProveedorSolicitud proveedorSolicitud) {
        Estado estado = new Estado();
        estado.setIdEstado(1);

        Proveedor proveedor = new Proveedor();
        proveedor.setNombreProveedor(proveedorSolicitud.getNombreProveedor());
        proveedor.setNumeroProveedor(proveedorSolicitud.getNumeroProveedor());
        proveedor.setCorreoProveedor(proveedorSolicitud.getCorreoProveedor());
        proveedor.setNombreEmpresa(proveedorSolicitud.getNombreEmpresa());
        proveedor.setNumeroEmpresa(proveedorSolicitud.getNumeroEmpresa());
        proveedor.setCorreoEmpresa(proveedorSolicitud.getCorreoEmpresa());
        proveedor.setDescripcionProducto(proveedorSolicitud.getDescripcionProducto());
        proveedor.setIdEstado(estado);

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