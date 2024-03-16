package com.sena.chef_control.dto;

import lombok.Data;

@Data
public class UsuarioRespuesta {
    private String numeroDocumento;
    private String rol;
    private String token;
    private String correo;
}