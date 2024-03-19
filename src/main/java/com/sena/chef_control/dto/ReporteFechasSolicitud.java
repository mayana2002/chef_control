package com.sena.chef_control.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReporteFechasSolicitud {
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
}