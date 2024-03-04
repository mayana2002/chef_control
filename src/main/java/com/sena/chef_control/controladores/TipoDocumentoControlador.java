package com.sena.chef_control.controladores;

import com.sena.chef_control.entidades.TipoDocumento;
import com.sena.chef_control.servicios.TipoDocumentoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tipos-documentos")
public class TipoDocumentoControlador {

    @Autowired
    private TipoDocumentoServicio tipoDocumentoServicio;

    @GetMapping
    public ResponseEntity<List<TipoDocumento>> listarInformacionTipoDocumentosControlador() {
        return ResponseEntity.ok(tipoDocumentoServicio.listarInformacionTipoDocumentos());
    }
}