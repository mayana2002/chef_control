package com.sena.chef_control.serviciosImpl;

import com.sena.chef_control.entidades.MedioPago;
import com.sena.chef_control.repositorios.MedioPagoRepositorio;
import com.sena.chef_control.servicios.MedioPagoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedioPagoServicioImpl implements MedioPagoServicio {

    @Autowired
    private MedioPagoRepositorio medioPagoRepositorio;

    @Override
    public List<MedioPago> listarInformacionMediosPagos() {
        return medioPagoRepositorio.findAll();
    }
}