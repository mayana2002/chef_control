package com.sena.chef_control.dto;

import lombok.Data;

@Data
public class VentaSolicitud {
    private int cantidadVenta;
    private String numeroDocumento;
    private Double precioTotal;
    private Double valorRecibido;
    private Double valorCambio;
    private int idMedioPago;
    private Integer idVenta;
}