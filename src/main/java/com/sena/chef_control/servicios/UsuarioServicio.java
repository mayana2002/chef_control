package com.sena.chef_control.servicios;

import com.sena.chef_control.entidades.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioServicio {

    public Usuario registrarUsuario(Usuario usuario);

    public List<Usuario> listarTodosUsuarios();

    public void cambiarEstadoUsuarioServicio(int numeroDocumento, int idEstado);

    public Optional<Usuario> inicioSesionUsuarioServicio(String correo);

    public Usuario listarUsuarioIdServicio(String numeroDocumento);
}