package com.sena.chef_control.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_ventas")
public class Venta {

    @Id
    @Column(name = "id_venta")
    private int idVenta;

    @Column(name = "fecha_venta")
    private LocalDateTime fechaVenta;

    @Column(name = "cantidad_venta")
    private int cantidadVenta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "numero_documento")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Usuario numeroDocumento;

    @Column(name = "precio_total")
    private Double precioTotal;

    @Column(name = "valor_recibido")
    private Double valorRecibido;

    @Column(name = "valor_cambio")
    private Double valorCambio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_medio_pago")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private MedioPago idMedioPago;

    @PrePersist
    protected void fechaActual() {
        this.fechaVenta = LocalDateTime.now();
    }
}