package com.sena.chef_control.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_inventarios_inmuebles")
public class InventarioInmueble {

    @Id
    @Column(name = "id_inventario_inmueble")
    private int idInventarioInmueble;

    @Column(name = "nombre_inmueble")
    private String nombreInmueble;

    @Column(name = "descripcion_inmueble")
    private String descripcionInmueble;

    @Column(name = "cantidad_inmueble")
    private int cantidadInmueble;

    @Column(name = "fecha_registro_inmueble")
    private LocalDateTime fechaRegistroInmueble;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "numero_documento")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Usuario numeroDocumento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Estado idEstado;

    @PrePersist
    protected void fechaActual() {
        this.fechaRegistroInmueble = LocalDateTime.now();
    }
}