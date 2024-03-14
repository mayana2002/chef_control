package com.sena.chef_control.dto;

import lombok.Data;

@Data
public class InventarioInmuebleSolicitud {
    private String nombreInmueble;
    private String descripcionInmueble;
    private int cantidadInmueble;
    private String numeroDocumento;
}