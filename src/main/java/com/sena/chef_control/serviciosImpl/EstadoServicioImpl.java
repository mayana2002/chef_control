package com.sena.chef_control.serviciosImpl;

import com.sena.chef_control.entidades.Estado;
import com.sena.chef_control.repositorios.EstadoRepositorio;
import com.sena.chef_control.servicios.EstadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoServicioImpl implements EstadoServicio {

    @Autowired
    private EstadoRepositorio estadoRepositorio;

    @Override
    public List<Estado> listarInformacionEstados() {
        return estadoRepositorio.findAll();
    }
}