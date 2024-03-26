package com.sena.chef_control.serviciosImpl;

import com.sena.chef_control.entidades.Venta;
import com.sena.chef_control.repositorios.VentaRepositorio;
import com.sena.chef_control.servicios.VentaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VentaServicioImpl implements VentaServicio {

    @Autowired
    private VentaRepositorio ventaRepositorio;

    @Override
    public Venta crearVenta(Venta venta) {
        return ventaRepositorio.save(venta);
    }

    @Override
    public List<Venta> listarVentaFechasServicio(LocalDateTime fechaInicial, LocalDateTime fechaFinal) {
        return ventaRepositorio.listarVentaFechasRepositorio(fechaInicial, fechaFinal);
    }
}