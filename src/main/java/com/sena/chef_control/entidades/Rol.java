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
@Table(name = "tb_roles_usuarios", schema = "chef_control")
public class Rol {

    @Id
    @Column(name = "id_rol_usuario")
    private int idRolUsuario;

    @Column(name = "rol_usuario")
    private String rolUsuario;
}