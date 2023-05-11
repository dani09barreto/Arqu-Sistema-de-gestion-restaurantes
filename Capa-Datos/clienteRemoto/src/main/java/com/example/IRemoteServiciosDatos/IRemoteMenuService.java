package com.example.IRemoteServiciosDatos;

import com.example.entidades.Menu;
import jakarta.ejb.Remote;

import java.util.List;

@Remote
public interface IRemoteMenuService {
    void agregarMenu(Menu menu);
    void actualizarMenu(Menu menu);
    void eliminarMenu(Long id);
    Menu obtenerMenu(Long id);
    List<Menu> obtenerTodosMenus();
}
