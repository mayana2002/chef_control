package com.sena.chef_control.controladores;

import com.sena.chef_control.dto.MenuSolicitud;
import com.sena.chef_control.entidades.CategoriaMenu;
import com.sena.chef_control.entidades.Estado;
import com.sena.chef_control.entidades.Menu;
import com.sena.chef_control.servicios.MenuServicio;
import com.sena.chef_control.utilidad.JwtUtilidad;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuControlador {

    @Autowired
    private MenuServicio menuServicio;

    @Autowired
    private JwtUtilidad jwtUtilidad;

    @PostMapping
    public ResponseEntity<Menu> crearMenuControlador(@RequestBody MenuSolicitud menuSolicitud, @RequestHeader("Authorization") String token) {
        if (token == null || !token.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String jwtToken = token.substring(7); // Eliminar "Bearer " del token

        if (!jwtUtilidad.validateToken(jwtToken)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Estado estado = new Estado();
        estado.setIdEstado(1);

        CategoriaMenu categoriaMenu = new CategoriaMenu();
        categoriaMenu.setIdCategoriaMenu(menuSolicitud.getIdCategoriaMenu());

        Menu menu = new Menu();
        menu.setNombreMenu(menuSolicitud.getNombreMenu());
        menu.setDescripcionMenu(menuSolicitud.getDescripcionMenu());
        menu.setPrecioMenu(menuSolicitud.getPrecioMenu());
        menu.setIdEstado(estado);
        menu.setIdCategoriaMenu(categoriaMenu);

        return ResponseEntity.ok(menuServicio.crearMenu(menu));
    }

    @GetMapping
    public ResponseEntity<List<Menu>> listarTodoMenuControlador(@RequestHeader("Authorization") String token) {
        if (token == null || !token.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String jwtToken = token.substring(7); // Eliminar "Bearer " del token

        if (!jwtUtilidad.validateToken(jwtToken)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(menuServicio.listarTodoMenuServicio());
    }

    @GetMapping("/{idMenu}")
    public ResponseEntity<Menu> listarMenuIdControlador(@PathVariable int idMenu, @RequestHeader("Authorization") String token) {
        if (token == null || !token.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String jwtToken = token.substring(7); // Eliminar "Bearer " del token

        if (!jwtUtilidad.validateToken(jwtToken)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.ok(menuServicio.listarMenuIdServicio(idMenu));
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<Menu>> listarMenuPorNombre(@PathVariable String nombre, @RequestHeader("Authorization") String token) {
        if (token == null || !token.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        String jwtToken = token.substring(7); // Eliminar "Bearer " del token

        if (!jwtUtilidad.validateToken(jwtToken)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        List<Menu> menus = menuServicio.listarCategoriaNombreServicio(nombre);
        if (menus.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(menus);
        }
    }
}