package com.example.modeloGeneral.GestionDatos.intf;

import com.example.entidades.Menu;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface IMenuService {
    void agregarMenu(Menu menu);
    void actualizarMenu(Menu menu);
    void eliminarMenu(Long id);
    Menu obtenerMenu(Long id);
    List<Menu> obtenerTodosMenus();
}
