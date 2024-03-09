package com.sena.chef_control.servicios;

import com.sena.chef_control.entidades.Menu;

import java.util.List;

public interface MenuServicio {

    public Menu crearMenu(Menu menu);

    public List<Menu> listarTodoMenuServicio();
}