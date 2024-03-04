package com.sena.chef_control.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_medios_pagos", schema = "chef_control")
public class MedioPago {

    @Id
    @Column(name = "id_medio_pago")
    private int idMedioPago;

    @Column(name = "descripcion_tipo_pago")
    private String descripcionTipoPago;
}