package com.example.modeloGeneral.RemoteServiciosData;

import com.example.IRemoteServiciosDatos.IRemoteMenuService;
import com.example.modeloGeneral.GestionDatos.intf.IMenuService;
import com.example.entidades.Menu;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class RemoteMenuService implements IRemoteMenuService {

    @EJB
    IMenuService menuService;

    @Override
    public Menu agregarMenu(Menu menu) {
        return menuService.agregarMenu(menu);
    }

    @Override
    public void actualizarMenu(Menu menu) {
        menuService.actualizarMenu(menu);
    }

    @Override
    public void eliminarMenu(Long id) {
        menuService.eliminarMenu(id);
    }

    @Override
    public Menu obtenerMenu(Long id) {
        return menuService.obtenerMenu(id);
    }

    @Override
    public List<Menu> obtenerTodosMenus() {
        return menuService.obtenerTodosMenus();
    }
}
