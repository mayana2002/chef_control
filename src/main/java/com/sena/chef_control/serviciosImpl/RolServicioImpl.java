package com.sena.chef_control.serviciosImpl;

import com.sena.chef_control.entidades.Rol;
import com.sena.chef_control.repositorios.RolRepositorio;
import com.sena.chef_control.servicios.RolServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServicioImpl implements RolServicio {

    @Autowired
    private RolRepositorio rolRepositorio;

    @Override
    public List<Rol> listarInformacionRol() {
        return rolRepositorio.findAll();
    }
}