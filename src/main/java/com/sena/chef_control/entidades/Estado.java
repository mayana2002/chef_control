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
@Table(name = "tb_estados", schema = "chef_control")
public class Estado {

    @Id
    @Column(name = "id_estado")
    private int idEstado;

    @Column(name = "nombre_estado")
    private String nombreEstado;
}