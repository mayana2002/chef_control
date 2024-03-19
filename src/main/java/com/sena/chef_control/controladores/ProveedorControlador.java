package com.sena.chef_control.controladores;

import com.sena.chef_control.dto.CorreoProveedorSolicitud;
import com.sena.chef_control.dto.ProveedorSolicitud;
import com.sena.chef_control.entidades.Estado;
import com.sena.chef_control.entidades.Proveedor;
import com.sena.chef_control.servicios.ProveedorServicio;
import com.sena.chef_control.utilidad.JwtUtilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedores")
public class ProveedorControlador {

    @Autowired
    private ProveedorServicio proveedorServicio;

    @Autowired
    private JwtUtilidad jwtUtilidad;

    @PostMapping("/crear")
    public ResponseEntity<Proveedor> registrarProveedorControlador(@RequestBody ProveedorSolicitud proveedorSolicitud, @RequestHeader("Authorization") String token) {
        if (token == null || !token.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String jwtToken = token.substring(7); // Eliminar "Bearer " del token

        if (!jwtUtilidad.validateToken(jwtToken)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

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
    public ResponseEntity<List<Proveedor>> listarTodosProveedoresControlador(@RequestHeader("Authorization") String token) {
        if (token == null || !token.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String jwtToken = token.substring(7); // Eliminar "Bearer " del token

        if (!jwtUtilidad.validateToken(jwtToken)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(proveedorServicio.listarTodosProveedoresServicio());
    }

    @PutMapping("/cambiar-estado/{idProveedor}/{idEstado}")
    public void cambiarEstadoProveedorService(@PathVariable int idProveedor, @PathVariable int idEstado) {
        proveedorServicio.cambiarEstadoProveedorService(idProveedor, idEstado);
    }

    @GetMapping("/{idProveedor}")
    public ResponseEntity<Proveedor> listarProveedorIdControlador(@PathVariable int idProveedor, @RequestHeader("Authorization") String token) {
        if (token == null || !token.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String jwtToken = token.substring(7); // Eliminar "Bearer " del token

        if (!jwtUtilidad.validateToken(jwtToken)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(proveedorServicio.listarProveedorIdServicio(idProveedor));
    }

    @GetMapping("/correo")
    public ResponseEntity<Proveedor> listarProveedorCorreoControlador(@RequestBody CorreoProveedorSolicitud correoProveedorSolicitud, String correoProveedor, @RequestHeader("Authorization") String token) {
        if (token == null || !token.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String jwtToken = token.substring(7); // Eliminar "Bearer " del token

        if (!jwtUtilidad.validateToken(jwtToken)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(proveedorServicio.listarProveedorCorreoServicio(correoProveedorSolicitud.getCorreo()));
    }
}