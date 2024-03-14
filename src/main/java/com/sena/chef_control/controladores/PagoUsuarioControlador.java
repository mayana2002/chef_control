package com.sena.chef_control.controladores;

import com.sena.chef_control.dto.PagoUsuarioSolicitud;
import com.sena.chef_control.entidades.MedioPago;
import com.sena.chef_control.entidades.PagoUsuario;
import com.sena.chef_control.entidades.Usuario;
import com.sena.chef_control.servicios.PagoUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pago-usuario")
public class PagoUsuarioControlador {

    @Autowired
    private PagoUsuarioServicio pagoUsuarioServicio;

    @PostMapping("/crear")
    public ResponseEntity<PagoUsuario> crearPagoUsuarioControlador(@RequestBody PagoUsuarioSolicitud pagoUsuarioSolicitud) {
        Usuario usuario = new Usuario();
        usuario.setNumeroDocumento(pagoUsuarioSolicitud.getNumeroDocumento());

        MedioPago medioPago = new MedioPago();
        medioPago.setIdMedioPago(pagoUsuarioSolicitud.getIdMedioPago());

        PagoUsuario pagoUsuario = new PagoUsuario();
        pagoUsuario.setValorPagado(pagoUsuarioSolicitud.getValorPagado());
        pagoUsuario.setDescripcionPago(pagoUsuarioSolicitud.getDescripcionPago());
        pagoUsuario.setNumeroDocumento(usuario);
        pagoUsuario.setIdMedioPago(medioPago);
        return ResponseEntity.ok(pagoUsuarioServicio.craerPagoUsuario(pagoUsuario));
    }

    @GetMapping
    public ResponseEntity<List<PagoUsuario>> listarTodosPagosControlador() {
        return ResponseEntity.ok(pagoUsuarioServicio.listarTodosPagosServicio());
    }
}