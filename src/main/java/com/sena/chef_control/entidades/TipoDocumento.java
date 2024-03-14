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
@Table(name = "tb_tipos_documentos", schema = "chef_control")
public class TipoDocumento {
    @Id
    @Column(name = "id_tipo_documento")
    private int idTipoDocumento;

    @Column(name = "tipo_documento")
    private String tipoDocumento;
}