package com.sena.chef_control.servicios;

import com.sena.chef_control.entidades.PagoUsuario;

import java.util.List;

public interface PagoUsuarioServicio {

    public PagoUsuario craerPagoUsuario(PagoUsuario pagoUsuario);

    public List<PagoUsuario> listarTodosPagosServicio();
}