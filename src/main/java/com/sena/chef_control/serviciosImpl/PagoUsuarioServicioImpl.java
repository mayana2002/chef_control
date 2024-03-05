package com.sena.chef_control.serviciosImpl;

import com.sena.chef_control.entidades.PagoUsuario;
import com.sena.chef_control.repositorios.PagoUsuarioRepositorio;
import com.sena.chef_control.servicios.PagoUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagoUsuarioServicioImpl implements PagoUsuarioServicio {

    @Autowired
    private PagoUsuarioRepositorio pagoUsuarioRepositorio;

    @Override
    public PagoUsuario craerPagoUsuario(PagoUsuario pagoUsuario) {
        return pagoUsuarioRepositorio.save(pagoUsuario);
    }
}