package com.sena.chef_control.servicios;

import com.sena.chef_control.entidades.VentaDetalle;

public interface VentaDetalleServicio {
    public VentaDetalle crearVentaDetalle(VentaDetalle ventaDetalle);
    public void actualizarCantidadMenuServicio(int idVentaDetalle, int nuevaCantidad);
}