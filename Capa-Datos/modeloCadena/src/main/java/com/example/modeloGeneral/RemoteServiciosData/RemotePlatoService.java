package com.example.modeloGeneral.RemoteServiciosData;

import com.example.IRemoteServiciosDatos.IRemotePlatoService;
import com.example.modeloGeneral.GestionDatos.intf.IMenuService;
import com.example.modeloGeneral.GestionDatos.intf.IPlatoService;
import com.example.entidades.Menu;
import com.example.entidades.Plato;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class RemotePlatoService implements IRemotePlatoService {

    @EJB
    IMenuService menuService;

    @EJB
    IPlatoService platoService;

    @Override
    public void agregarPlato(Plato plato) {
        platoService.agregarPlato(plato);
    }

    @Override
    public void actualizarPlato(Plato plato) {
        platoService.actualizarPlato(plato);
    }

    @Override
    public void eliminarPlato(Long id) {
        platoService.eliminarPlato(id);
    }

    @Override
    public Plato obtenerPlato(Long id) {
        return platoService.obtenerPlato(id);
    }

    @Override
    public List<Plato> obtenerTodosPlatosPorMenu(Long Menuid) {
        Menu menu = menuService.obtenerMenu(Menuid);
        return platoService.obtenerTodosPlatosPorMenu(menu);
    }
}
