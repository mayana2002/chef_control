package com.sena.chef_control.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_pagos_usuarios", schema = "chef_control")
public class PagoUsuario {

    @Id
    @Column(name = "id_pago_usuario")
    private int idPagoUsuario;

    @Column(name = "fecha_pago")
    private LocalDateTime fechaPago;

    @Column(name = "valor_pagado")
    private Double valorPagado;

    @Column(name = "descripcion_pago")
    private String descripcionPago;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "numero_documento")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Usuario numeroDocumento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_medio_pago")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private MedioPago idMedioPago;

    @PrePersist
    protected void fechaActual() {
        this.fechaPago = LocalDateTime.now();
    }
}