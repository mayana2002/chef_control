package com.sena.chef_control.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReporteFechasVentas {
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
}
