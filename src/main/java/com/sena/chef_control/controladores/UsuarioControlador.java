package com.sena.chef_control.controladores;

import com.sena.chef_control.dto.InicioSesionSolicitud;
import com.sena.chef_control.dto.UsuarioSolicitud;
import com.sena.chef_control.entidades.Estado;
import com.sena.chef_control.entidades.Rol;
import com.sena.chef_control.entidades.TipoDocumento;
import com.sena.chef_control.entidades.Usuario;
import com.sena.chef_control.servicios.UsuarioServicio;
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
        usuario.setContrasena(usuarioSolicitud.getContrasena());
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
    public ResponseEntity<Usuario> inicioSesionUsuarioControlador(@RequestBody InicioSesionSolicitud inicioSesionSolicitud) {
        Optional<Usuario> optionalUsuario = usuarioServicio.inicioSesionUsuarioServicio(inicioSesionSolicitud.getCorreo());

        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

            if (passwordEncoder.matches(inicioSesionSolicitud.getContrasena(), usuario.getContrasena())) {
                return ResponseEntity.ok(usuario);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // Use HTTP status code
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}