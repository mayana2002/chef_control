package com.sena.chef_control.servicios;


import com.sena.chef_control.entidades.RespuestaPregunta;

import java.util.List;

public interface RespuestaPreguntaServicio {
    public List<RespuestaPregunta> listarRespuestaPregunta();

    public RespuestaPregunta listarRespuestaPorPreguntaServicio(String descripcionRespuesta, int idPregunta);
}