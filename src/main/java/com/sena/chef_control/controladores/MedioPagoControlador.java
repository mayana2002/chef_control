package com.sena.chef_control.controladores;

import com.sena.chef_control.entidades.MedioPago;
import com.sena.chef_control.servicios.MedioPagoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/medios-pagos")
public class MedioPagoControlador {

    @Autowired
    private MedioPagoServicio medioPagoServicio;

    @GetMapping
    public ResponseEntity<List<MedioPago>> listarInformacionMediosPagosControlador() {
        return ResponseEntity.ok(medioPagoServicio.listarInformacionMediosPagos());
    }
}