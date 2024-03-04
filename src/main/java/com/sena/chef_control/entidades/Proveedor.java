package com.sena.chef_control.entidades;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_proveedores", schema = "chef_control")
public class Proveedor {

    @Id
    @Column(name = "id_proveedor")
    private int idProveedor;

    @Column(name = "nombre_proveedor")
    private String nombreProveedor;

    @Column(name = "numero_proveedor")
    private int numeroProveedor;

    @Column(name = "correo_proveedor")
    private String correoProveedor;

    @Column(name = "nombre_empresa")
    private String nombreEmpresa;

    @Column(name = "numero_empresa")
    private int numeroEmpresa;

    @Column(name = "correo_empresa")
    private String correoEmpresa;

    @Column(name = "descripcion_producto")
    private String descripcionProducto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado")
    private Estado idEstado;
}