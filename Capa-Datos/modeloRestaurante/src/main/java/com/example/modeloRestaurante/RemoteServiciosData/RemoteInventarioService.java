package com.example.modeloRestaurante.RemoteServiciosData;

import com.example.IRemoteServiciosDatos.IRemoteInventarioService;
import com.example.entidades.Inventario;
import com.example.modeloRestaurante.GestionDatos.Interfaces.IInventarioService;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class RemoteInventarioService implements IRemoteInventarioService {
    @EJB
    IInventarioService inventarioService;

    @Override
    public void agregarInventario(Inventario inventario) {
        inventarioService.agregarInventario(inventario);
    }

    @Override
    public void actualizarInventario(Inventario inventario) {
        inventarioService.actualizarInventario(inventario);
    }

    @Override
    public void eliminarInventario(Long id) {
        inventarioService.eliminarInventario(id);
    }

    @Override
    public Inventario obtenerInventario(Long id) {
        return inventarioService.obtenerInventario(id);
    }

    @Override
    public List<Inventario> obtenerTodosInventarios() {
        return inventarioService.obtenerTodosInventarios();
    }
}
