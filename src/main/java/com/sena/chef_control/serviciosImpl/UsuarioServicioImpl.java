package com.sena.chef_control.serviciosImpl;

import com.sena.chef_control.entidades.Usuario;
import com.sena.chef_control.repositorios.UsuarioRepositorio;
import com.sena.chef_control.servicios.UsuarioServicio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    @Transactional
    public Usuario registrarUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public List<Usuario> listarTodosUsuarios() {
        return usuarioRepositorio.listarTodosUsuariosRepositorio();
    }

    @Override
    public void cambiarEstadoUsuarioServicio(int numeroDocumento, int idEstado) {
        usuarioRepositorio.cambiarEstadoUsuarioRepositorio(numeroDocumento, idEstado);
    }

    @Override
    public Usuario inicioSesionUsuarioServicio(String correo, String contrasena) {
        return usuarioRepositorio.inicioSesionUsuarioRepositorio(correo, contrasena);
    }
}