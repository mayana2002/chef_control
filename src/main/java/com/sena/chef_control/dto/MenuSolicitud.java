package com.sena.chef_control.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MenuSolicitud {
    private String nombreMenu;
    private String descripcionMenu;
    private BigDecimal precioMenu;
    private int idCategoriaMenu;
}