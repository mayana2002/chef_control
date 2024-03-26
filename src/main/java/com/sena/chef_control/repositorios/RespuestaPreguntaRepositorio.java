package com.sena.chef_control.repositorios;

import com.sena.chef_control.entidades.RespuestaPregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RespuestaPreguntaRepositorio extends JpaRepository<RespuestaPregunta, Integer> {

    @Query("SELECT u FROM RespuestaPregunta u JOIN FETCH u.idPregunta e JOIN FETCH u.numeroDocumento td")
    List<RespuestaPregunta> listarRespuestaPreguntaRepositorio();

    @Query("SELECT rp FROM RespuestaPregunta rp WHERE rp.descripcionRespuesta = :descripcionRespuesta AND rp.idPregunta.idPregunta = :idPregunta")
    RespuestaPregunta listarRespuestaPorPreguntaRepositorio(@Param("descripcionRespuesta") String descripcionRespuesta, @Param("idPregunta") int idPregunta);
}