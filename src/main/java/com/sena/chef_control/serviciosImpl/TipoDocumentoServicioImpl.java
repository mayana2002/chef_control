package com.sena.chef_control.serviciosImpl;

import com.sena.chef_control.entidades.TipoDocumento;
import com.sena.chef_control.repositorios.TipoDocumentoRepositorio;
import com.sena.chef_control.servicios.TipoDocumentoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoDocumentoServicioImpl implements TipoDocumentoServicio {

    @Autowired
    private TipoDocumentoRepositorio tipoDocumentoRepositorio;

    @Override
    public List<TipoDocumento> listarInformacionTipoDocumentos() {
        return tipoDocumentoRepositorio.findAll();
    }
}