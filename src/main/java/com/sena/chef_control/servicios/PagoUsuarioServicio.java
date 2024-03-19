package com.sena.chef_control.servicios;

import com.sena.chef_control.entidades.PagoUsuario;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PagoUsuarioServicio {

    public PagoUsuario craerPagoUsuario(PagoUsuario pagoUsuario);

    public List<PagoUsuario> listarTodosPagosServicio();

    List<PagoUsuario> listarPagoUsuarioFechasServicio(LocalDateTime fechaInicial, LocalDateTime fechaFinal);

    List<PagoUsuario> listarPagoUsuarioPorUsuarioServicio(String numeroDocumento);

    List<PagoUsuario> listarPagoUsuarioMedioPagoServicio(String descripcionTipoPago);

    List<PagoUsuario> listarPagoUsuarioConFiltrosServicio(LocalDateTime fechaInicial, LocalDateTime fechaFinal, String numeroDocumento,String descripcionTipoPago);
}