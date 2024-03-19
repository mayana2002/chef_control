package com.sena.chef_control.controladores;

import com.sena.chef_control.dto.VentaSolicitud;
import com.sena.chef_control.entidades.MedioPago;
import com.sena.chef_control.entidades.Usuario;
import com.sena.chef_control.entidades.Venta;
import com.sena.chef_control.servicios.VentaServicio;
import com.sena.chef_control.utilidad.JwtUtilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/venta")
public class VentaControlador {

    @Autowired
    private VentaServicio ventaServicio;

    @Autowired
    private JwtUtilidad jwtUtilidad;

    @PostMapping("/crear")
    public ResponseEntity<Venta> crearVentaControlador(@RequestBody VentaSolicitud ventaSolicitud, @RequestHeader("Authorization") String token) {
        if (token == null || !token.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String jwtToken = token.substring(7); // Eliminar "Bearer " del token

        if (!jwtUtilidad.validateToken(jwtToken)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Usuario usuario = new Usuario();
        usuario.setNumeroDocumento(ventaSolicitud.getNumeroDocumento());

        MedioPago medioPago = new MedioPago();
        medioPago.setIdMedioPago(ventaSolicitud.getIdMedioPago());

        Venta venta = new Venta();
        venta.setCantidadVenta(ventaSolicitud.getCantidadVenta());
        venta.setNumeroDocumento(usuario);
        venta.setPrecioTotal(ventaSolicitud.getPrecioTotal());
        venta.setValorRecibido(ventaSolicitud.getValorRecibido());
        venta.setValorCambio(ventaSolicitud.getValorCambio());
        venta.setIdMedioPago(medioPago);
        if (ventaSolicitud.getIdVenta() != null) {
            venta.setIdVenta(ventaSolicitud.getIdVenta());
        }
        return ResponseEntity.ok(ventaServicio.crearVenta(venta));
    }
}
