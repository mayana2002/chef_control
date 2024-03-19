package com.sena.chef_control.repositorios;

import com.sena.chef_control.entidades.PagoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PagoUsuarioRepositorio extends JpaRepository<PagoUsuario, Integer> {
    @Query("SELECT u FROM PagoUsuario u JOIN FETCH u.numeroDocumento e JOIN FETCH u.idMedioPago td")
    List<PagoUsuario> listarTodosPagosRepositorio();

    @Query("SELECT p FROM PagoUsuario p WHERE p.fechaPago BETWEEN :fechaInicial AND :fechaFinal")
    List<PagoUsuario> listarPagoUsuarioFechasRepositorio(@Param("fechaInicial") LocalDateTime fechaInicial, @Param("fechaFinal") LocalDateTime fechaFinal);
}