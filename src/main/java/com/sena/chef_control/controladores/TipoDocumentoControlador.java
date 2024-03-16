package com.sena.chef_control.controladores;

import com.sena.chef_control.entidades.TipoDocumento;
import com.sena.chef_control.servicios.TipoDocumentoServicio;
import com.sena.chef_control.utilidad.JwtUtilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tipos-documentos")
public class TipoDocumentoControlador {

    @Autowired
    private TipoDocumentoServicio tipoDocumentoServicio;

    @Autowired
    private JwtUtilidad jwtUtilidad;

    @GetMapping
    public ResponseEntity<List<TipoDocumento>> listarInformacionTipoDocumentosControlador(@RequestHeader("Authorization") String token) {
        if (token == null || !token.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String jwtToken = token.substring(7); // Eliminar "Bearer " del token

        if (!jwtUtilidad.validateToken(jwtToken)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(tipoDocumentoServicio.listarInformacionTipoDocumentos());
    }
}