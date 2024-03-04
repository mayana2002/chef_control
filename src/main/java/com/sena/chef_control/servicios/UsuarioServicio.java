package com.sena.chef_control.servicios;

import com.sena.chef_control.entidades.Usuario;

import java.util.List;

public interface UsuarioServicio {

    public Usuario registrarUsuario(Usuario usuario);

    public List<Usuario> listarTodosUsuarios();

    public void cambiarEstadoUsuarioServicio(int numeroDocumento, int idEstado);

    public Usuario inicioSesionUsuarioServicio(String correo, String contrasena);
}