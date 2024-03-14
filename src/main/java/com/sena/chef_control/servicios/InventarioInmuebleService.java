package com.sena.chef_control.servicios;

import com.sena.chef_control.entidades.InventarioInmueble;

import java.util.List;

public interface InventarioInmuebleService {

    public InventarioInmueble registrarInventarioInmueble(InventarioInmueble inventarioInmueble);

    public List<InventarioInmueble> listarTodosInmueblesService();
}
