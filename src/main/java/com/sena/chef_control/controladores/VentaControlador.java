package com.sena.chef_control.controladores;

import com.sena.chef_control.dto.VentaSolicitud;
import com.sena.chef_control.entidades.MedioPago;
import com.sena.chef_control.entidades.Usuario;
import com.sena.chef_control.entidades.Venta;
import com.sena.chef_control.servicios.VentaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/venta")
public class VentaControlador {

    @Autowired
    private VentaServicio ventaServicio;

    @PostMapping("/crear")
    public ResponseEntity<Venta> crearVentaControlador(@RequestBody VentaSolicitud ventaSolicitud) {
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

        return ResponseEntity.ok(ventaServicio.crearVenta(venta));
    }
}
