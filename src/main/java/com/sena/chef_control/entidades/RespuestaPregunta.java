package com.sena.chef_control.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_respuestas_preguntas", schema = "chef_control")
public class RespuestaPregunta {

    @Id
    @Column(name = "id_respuesta_pregunta")
    private int idRespiuestaPregunta;

    @Column(name = "descripcion_respuesta")
    private String descripcionRespuesta;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pregunta")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Pregunta idPregunta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "numero_documento")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Usuario numeroDocumento;
}