package com.sena.chef_control.serviciosImpl;

import com.sena.chef_control.entidades.Pregunta;
import com.sena.chef_control.repositorios.PreguntaRepositorio;
import com.sena.chef_control.servicios.PreguntaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreguntaServicioImpl implements PreguntaServicio {

    @Autowired
    private PreguntaRepositorio preguntaRepositorio;

    @Override
    public List<Pregunta> listarPreguntas() {
        return preguntaRepositorio.findAll();
    }
}