package com.sena.chef_control.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.awt.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_ventas_detalles", schema = "chef_control")
public class VentaDetalle {

    @Id
    @Column(name = "id_venta_detalle")
    private int idVentaDetalle;

    @Column(name = "cantidad_menu")
    private int cantidadMenu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_menu")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Menu idMenu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_venta")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Venta idVenta;
}