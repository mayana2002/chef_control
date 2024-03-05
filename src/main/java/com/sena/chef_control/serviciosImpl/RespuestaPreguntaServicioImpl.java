package com.sena.chef_control.serviciosImpl;

import com.sena.chef_control.entidades.RespuestaPregunta;
import com.sena.chef_control.repositorios.RespuestaPreguntaRepositorio;
import com.sena.chef_control.servicios.RespuestaPreguntaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespuestaPreguntaServicioImpl implements RespuestaPreguntaServicio {

    @Autowired
    private RespuestaPreguntaRepositorio respuestaPreguntaRepositorio;

    @Override
    public List<RespuestaPregunta> listarRespuestaPregunta() {
        return respuestaPreguntaRepositorio.listarRespuestaPreguntaRepositorio();
    }
}