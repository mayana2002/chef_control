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
@Table(name = "tb_preguntas")
public class Pregunta {

    @Id
    @Column(name = "id_pregunta")
    private int idPregunta;

    @Column(name = "nombre_pregunta")
    private String nombrePregunta;
}