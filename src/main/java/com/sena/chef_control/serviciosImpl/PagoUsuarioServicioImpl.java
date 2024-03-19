package com.sena.chef_control.serviciosImpl;

import com.sena.chef_control.entidades.PagoUsuario;
import com.sena.chef_control.repositorios.PagoUsuarioRepositorio;
import com.sena.chef_control.servicios.PagoUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PagoUsuarioServicioImpl implements PagoUsuarioServicio {

    @Autowired
    private PagoUsuarioRepositorio pagoUsuarioRepositorio;

    @Override
    public PagoUsuario craerPagoUsuario(PagoUsuario pagoUsuario) {
        return pagoUsuarioRepositorio.save(pagoUsuario);
    }

    @Override
    public List<PagoUsuario> listarTodosPagosServicio() {
        return pagoUsuarioRepositorio.listarTodosPagosRepositorio();
    }

    @Override
    public List<PagoUsuario> listarPagoUsuarioFechasServicio(LocalDateTime fechaInicial, LocalDateTime fechaFinal) {
        return pagoUsuarioRepositorio.listarPagoUsuarioFechasRepositorio(fechaInicial, fechaFinal);
    }

    @Override
    public List<PagoUsuario> listarPagoUsuarioPorUsuarioServicio(String numeroDocumento) {
        return pagoUsuarioRepositorio.listarPagoUsuarioPorUsuario(numeroDocumento);
    }

    @Override
    public List<PagoUsuario> listarPagoUsuarioMedioPagoServicio(String descripcionTipoPago) {
        return pagoUsuarioRepositorio.listarPagoUsuarioMedioPago(descripcionTipoPago);
    }

    @Override
    public List<PagoUsuario> listarPagoUsuarioConFiltrosServicio(LocalDateTime fechaInicial, LocalDateTime fechaFinal, String numeroDocumento, String descripcionTipoPago) {
        return pagoUsuarioRepositorio.listarPagoUsuarioConFiltros(fechaInicial, fechaFinal, numeroDocumento, descripcionTipoPago);
    }
}