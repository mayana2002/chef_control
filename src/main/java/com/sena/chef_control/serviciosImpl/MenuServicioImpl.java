package com.sena.chef_control.serviciosImpl;

import com.sena.chef_control.entidades.Menu;
import com.sena.chef_control.repositorios.MenuRepositorio;
import com.sena.chef_control.servicios.MenuServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServicioImpl implements MenuServicio {

    @Autowired
    private MenuRepositorio menuRepositorio;

    @Override
    public Menu crearMenu(Menu menu) {
        return menuRepositorio.save(menu);
    }

    @Override
    public List<Menu> listarTodoMenuServicio() {
        return menuRepositorio.listarTodoMenuRepositorio();
    }
}