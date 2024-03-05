package com.sena.chef_control.dto;

import lombok.Data;

@Data
public class UsuarioSolicitud {
    private int numeroDocumento;
    private String nombreCompleto;
    private int telefono;
    private String direccion;
    private String correo;
    private String contrasena;
    private String rutaFoto;
    private int idTipoDocumento;
    private int idRolUsuario;
}
