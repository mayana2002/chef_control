package com.sena.chef_control.serviciosImpl;

import com.sena.chef_control.entidades.InventarioInmueble;
import com.sena.chef_control.repositorios.InventarioInmuebleRepositorio;
import com.sena.chef_control.servicios.InventarioInmuebleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioInmuebleServiceImpl implements InventarioInmuebleService {

    @Autowired
    private InventarioInmuebleRepositorio inventarioInmuebleRepositorio;

    @Override
    public InventarioInmueble registrarInventarioInmueble(InventarioInmueble inventarioInmueble) {
        return inventarioInmuebleRepositorio.save(inventarioInmueble);
    }

    @Override
    public List<InventarioInmueble> listarTodosInmueblesService() {
        return inventarioInmuebleRepositorio.listarTodosInmueblesRepositorio();
    }

    @Override
    public InventarioInmueble listarInmuebleIdServicio(int idInventarioInmueble) {
        return inventarioInmuebleRepositorio.listarInmuebleIdRepositorio(idInventarioInmueble);
    }

    @Override
    public void cambiarEstadoInventarioInmmuebleServicio(int idInventarioInmueble, int nuevoEstado) {
        inventarioInmuebleRepositorio.cambiarEstadoInventarioInmmuebleRepositorio(idInventarioInmueble, nuevoEstado);
    }
}