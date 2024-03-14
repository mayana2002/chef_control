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
@Entity
@Table(name = "tb_categorias_menus", schema = "chef_control")
public class CategoriaMenu {

    @Id
    @Column(name = "id_categoria_menu")
    private int idCategoriaMenu;

    @Column(name = "nombre_categoria")
    private String nombreCategoria;
}