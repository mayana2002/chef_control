package com.sena.chef_control.servicios;

import com.sena.chef_control.entidades.PagoUsuario;

import java.time.LocalDateTime;
import java.util.List;

public interface PagoUsuarioServicio {

    public PagoUsuario craerPagoUsuario(PagoUsuario pagoUsuario);

    public List<PagoUsuario> listarTodosPagosServicio();

    List<PagoUsuario> listarPagoUsuarioFechasServicio(LocalDateTime fechaInicial, LocalDateTime fechaFinal);
}