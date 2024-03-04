package com.sena.chef_control.serviciosImpl;

import com.sena.chef_control.entidades.Proveedor;
import com.sena.chef_control.repositorios.ProveedorRepositorio;
import com.sena.chef_control.servicios.ProveedorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServicioImpl implements ProveedorServicio {

    @Autowired
    private ProveedorRepositorio proveedorRepositorio;
    @Override
    public Proveedor registarProveedor(Proveedor proveedor) {
        return proveedorRepositorio.save(proveedor);
    }

    @Override
    public List<Proveedor> listarTodosProveedoresServicio() {
        return proveedorRepositorio.listarTodosProveedoresRepositorio();
    }

    @Override
    public void cambiarEstadoProveedorService(int idProveedor, int idEstado) {
        proveedorRepositorio.cambiarEstadoProveedorRepositorio(idProveedor, idEstado);
    }
}