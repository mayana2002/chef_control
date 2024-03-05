package com.sena.chef_control.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_usuarios", schema = "chef_control")
public class Usuario {

    @Id
    @Column(name = "numero_documento")
    private int numeroDocumento;

    @Column(name = "nombre_completo")
    private String nombreCompleto;

    @Column(name = "telefono")
    private int telefono;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "correo")
    private String correo;

    @Column(name = "contraseña")
    private String contrasena;

    @Column(name = "ruta_foto")
    private String rutaFoto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_documento")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private TipoDocumento idTipoDocumento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol_usuario")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Rol rolUsuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Estado idEstado;

    public void setContrasena(String contrasena) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.contrasena = passwordEncoder.encode(contrasena);
    }
}