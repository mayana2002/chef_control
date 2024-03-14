package com.sena.chef_control.dto;

import lombok.Data;

@Data
public class PagoUsuarioSolicitud {
    private Double valorPagado;
    private String descripcionPago;
    private String numeroDocumento;
    private int idMedioPago;
}