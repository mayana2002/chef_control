package com.sena.chef_control.serviciosImpl;

import com.sena.chef_control.entidades.CategoriaMenu;
import com.sena.chef_control.repositorios.CategoriaMenuRepositorio;
import com.sena.chef_control.servicios.CategoriaMenuServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaMenuServicioImpl implements CategoriaMenuServicio {

    @Autowired
    private CategoriaMenuRepositorio categoriaMenuRepositorio;

    @Override
    public List<CategoriaMenu> listarInformacionCategoriasMenus() {
        return categoriaMenuRepositorio.findAll();
    }
}
