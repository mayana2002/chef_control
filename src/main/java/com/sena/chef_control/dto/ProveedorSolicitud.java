package com.sena.chef_control.dto;

import lombok.Data;

@Data
public class ProveedorSolicitud {
    private String nombreProveedor;
    private int numeroProveedor;
    private String correoProveedor;
    private String nombreEmpresa;
    private int numeroEmpresa;
    private String correoEmpresa;
    private String descripcionProducto;
    private int idEstado;
}