package com.sena.chef_control.servicios;

import com.sena.chef_control.entidades.Proveedor;

import java.util.List;

public interface ProveedorServicio {

    public Proveedor registarProveedor(Proveedor proveedor);

    public List<Proveedor> listarTodosProveedoresServicio();

    public void cambiarEstadoProveedorService(int idProveedor, int idEstado);

    public Proveedor listarProveedorIdServicio(int idProveedor);

    Proveedor listarProveedorCorreoServicio(String correoProveedor);
}