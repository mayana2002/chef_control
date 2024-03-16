package com.sena.chef_control.repositorios;

import com.sena.chef_control.entidades.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
    @Query("SELECT u FROM Usuario u JOIN FETCH u.rolUsuario e JOIN FETCH u.idTipoDocumento td JOIN FETCH u.idEstado r")
    List<Usuario> listarTodosUsuariosRepositorio();

    @Modifying
    @Transactional
    @Query("UPDATE Usuario p SET p.idEstado.idEstado = :nuevoEstado WHERE p.numeroDocumento = :numeroDocumento")
    void cambiarEstadoUsuarioRepositorio(@Param("numeroDocumento") int numeroDocumento, @Param("nuevoEstado") int nuevoEstado);

    @Query("SELECT u FROM Usuario u WHERE u.correo = :correo")
    Optional<Usuario> inicioSesionUsuarioRepositorio(@Param("correo") String correo);

    @Query("SELECT u FROM Usuario u JOIN FETCH u.rolUsuario e JOIN FETCH u.idTipoDocumento td JOIN FETCH u.idEstado r WHERE u.numeroDocumento = :numeroDocumento")
    Usuario listarUsuarioIdRepositorio(@Param("numeroDocumento") String numeroDocumento);
}