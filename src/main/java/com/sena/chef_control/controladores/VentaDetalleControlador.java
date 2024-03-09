package com.sena.chef_control.controladores;

import com.sena.chef_control.dto.VentaDetalleSolicitud;
import com.sena.chef_control.entidades.Menu;
import com.sena.chef_control.entidades.Venta;
import com.sena.chef_control.entidades.VentaDetalle;
import com.sena.chef_control.servicios.VentaDetalleServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/venta-detalle")
public class VentaDetalleControlador {

    @Autowired
    private VentaDetalleServicio ventaDetalleServicio;

    @PostMapping
    public ResponseEntity<VentaDetalle> crearVentaDetalleControlador(@RequestBody VentaDetalleSolicitud ventaDetalleSolicitud) {
        Venta venta = new Venta();
        venta.setIdVenta(ventaDetalleSolicitud.getIdVenta());

        Menu menu = new Menu();
        menu.setIdMenu(ventaDetalleSolicitud.getIdMenu());

        VentaDetalle ventaDetalle = new VentaDetalle();
        ventaDetalle.setIdVenta(venta);
        ventaDetalle.setIdMenu(menu);
        ventaDetalle.setCantidadMenu(1);

        return ResponseEntity.ok(ventaDetalleServicio.crearVentaDetalle(ventaDetalle));
    }

    @PutMapping("/cambiar-estado/{idVentaDetalle}/{nuevaCantidad}")
    public void actualizarCantidadMenuControlador(@PathVariable int idVentaDetalle, @PathVariable int nuevaCantidad) {
        ventaDetalleServicio.actualizarCantidadMenuServicio(idVentaDetalle, nuevaCantidad);
    }
}