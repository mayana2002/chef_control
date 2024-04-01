package com.sena.chef_control.servicios;

import com.sena.chef_control.entidades.InventarioInmueble;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InventarioInmuebleService {

    public InventarioInmueble registrarInventarioInmueble(InventarioInmueble inventarioInmueble);

    public List<InventarioInmueble> listarTodosInmueblesService();

    public InventarioInmueble listarInmuebleIdServicio(int idInventarioInmueble);

    void cambiarEstadoInventarioInmmuebleServicio(int idInventarioInmueble, int nuevoEstado);
}
