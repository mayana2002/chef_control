package com.sena.chef_control.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_menus", schema = "chef_control")
public class Menu {

    @Id
    @Column(name = "id_menu")
    private int idMenu;

    @Column(name = "nombre_menu")
    private String nombreMenu;

    @Column(name = "descripcion_menu")
    private String descripcionMenu;

    @Column(name = "precio_menu")
    private BigDecimal precioMenu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Estado idEstado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria_menu")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private CategoriaMenu categoriaMenu;
}