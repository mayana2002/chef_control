package com.sena.chef_control.controladores;

import com.sena.chef_control.dto.InicioSesionSolicitud;
import com.sena.chef_control.dto.UsuarioRespuesta;
import com.sena.chef_control.dto.UsuarioSolicitud;
import com.sena.chef_control.entidades.Estado;
import com.sena.chef_control.entidades.Rol;
import com.sena.chef_control.entidades.TipoDocumento;
import com.sena.chef_control.entidades.Usuario;
import com.sena.chef_control.servicios.UsuarioServicio;

import com.sena.chef_control.utilidad.JwtUtilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private JwtUtilidad jwtUtil;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @PostMapping("/crear")
    public ResponseEntity<Usuario> registrarUsuarioControlador(@RequestBody UsuarioSolicitud usuarioSolicitud) {

        TipoDocumento tipoDocumento = new TipoDocumento();
        tipoDocumento.setIdTipoDocumento(usuarioSolicitud.getIdTipoDocumento());

        Rol rol = new Rol();
        rol.setIdRolUsuario(usuarioSolicitud.getIdRolUsuario());

        Estado estado = new Estado();
        estado.setIdEstado(1);

        Usuario usuario = new Usuario();
        usuario.setNumeroDocumento(String.valueOf(usuarioSolicitud.getNumeroDocumento()));
        usuario.setNombreCompleto(usuarioSolicitud.getNombreCompleto());
        usuario.setTelefono(usuarioSolicitud.getTelefono());
        usuario.setDireccion(usuarioSolicitud.getDireccion());
        usuario.setCorreo(usuarioSolicitud.getCorreo());
        usuario.setContrasena(encoder.encode(usuarioSolicitud.getContrasena()));
        usuario.setRutaFoto(usuarioSolicitud.getRutaFoto());
        usuario.setIdTipoDocumento(tipoDocumento);
        usuario.setRolUsuario(rol);
        usuario.setIdEstado(estado);

        usuario.setContrasena(usuario.getContrasena());
        return ResponseEntity.ok(usuarioServicio.registrarUsuario(usuario));
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarTodosUsuariosControlador() {
        return ResponseEntity.ok(usuarioServicio.listarTodosUsuarios());
    }

    @PutMapping("/cambiar-estado/{numeroDocumento}/{idEstado}")
    public void cambiarEstadoUsuarioControlador(@PathVariable int numeroDocumento, @PathVariable int idEstado) {
        usuarioServicio.cambiarEstadoUsuarioServicio(numeroDocumento, idEstado);
    }

    @PostMapping("/inicio-sesion")
    public ResponseEntity<UsuarioRespuesta> inicioSesionUsuarioControlador(@RequestBody InicioSesionSolicitud inicioSesionSolicitud) {
        Optional<Usuario> optionalUsuario = usuarioServicio.inicioSesionUsuarioServicio(inicioSesionSolicitud.getCorreo());
        UsuarioRespuesta usuarioRespuesta = new UsuarioRespuesta();
        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            String token = jwtUtil.generateToken(usuario.getCorreo());
            usuarioRespuesta.setToken(token);
            usuarioRespuesta.setNumeroDocumento(usuario.getNumeroDocumento());
            usuarioRespuesta.setRol(usuario.getRolUsuario().getRolUsuario());
            usuarioRespuesta.setCorreo(usuario.getCorreo());

            if (encoder.matches(inicioSesionSolicitud.getContrasena(), usuario.getContrasena())) {

                return ResponseEntity.ok(usuarioRespuesta);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}