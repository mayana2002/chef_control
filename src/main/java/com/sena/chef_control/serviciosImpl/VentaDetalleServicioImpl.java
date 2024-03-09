package com.sena.chef_control.serviciosImpl;

import com.sena.chef_control.entidades.VentaDetalle;
import com.sena.chef_control.repositorios.VentaDetalleRepositorio;
import com.sena.chef_control.servicios.VentaDetalleServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaDetalleServicioImpl implements VentaDetalleServicio {

    @Autowired
    private VentaDetalleRepositorio ventaDetalleRepositorio;


    @Override
    public VentaDetalle crearVentaDetalle(VentaDetalle ventaDetalle) {
        return ventaDetalleRepositorio.save(ventaDetalle);
    }

    @Override
    public void actualizarCantidadMenuServicio(int idVentaDetalle, int nuevaCantidad) {
        ventaDetalleRepositorio.actualizarCantidadMenuRepositorio(idVentaDetalle, nuevaCantidad);
    }
}
