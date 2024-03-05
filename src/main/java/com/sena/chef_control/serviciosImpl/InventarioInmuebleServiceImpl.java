package com.sena.chef_control.serviciosImpl;

import com.sena.chef_control.entidades.InventarioInmueble;
import com.sena.chef_control.repositorios.InventarioInmuebleRepositorio;
import com.sena.chef_control.servicios.InventarioInmuebleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventarioInmuebleServiceImpl implements InventarioInmuebleService {

    @Autowired
    private InventarioInmuebleRepositorio inventarioInmuebleRepositorio;

    @Override
    public InventarioInmueble registrarInventarioInmueble(InventarioInmueble inventarioInmueble) {
        return inventarioInmuebleRepositorio.save(inventarioInmueble);
    }
}