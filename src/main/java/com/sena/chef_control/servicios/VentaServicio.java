package com.sena.chef_control.servicios;

import com.sena.chef_control.entidades.Venta;

import java.time.LocalDateTime;
import java.util.List;

public interface VentaServicio {

    public Venta crearVenta(Venta venta);

    public List<Venta> listarVentaFechasServicio(LocalDateTime fechaInicial, LocalDateTime fechaFinal);
}