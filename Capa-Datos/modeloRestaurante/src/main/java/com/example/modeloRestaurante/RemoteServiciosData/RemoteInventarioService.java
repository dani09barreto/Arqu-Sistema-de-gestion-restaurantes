package com.example.modeloRestaurante.RemoteServiciosData;

import com.example.IRemoteServiciosDatos.IRemoteInventarioRService;
import com.example.entidades.InventarioR;
import com.example.modeloRestaurante.GestionDatos.Interfaces.IInventarioService;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class RemoteInventarioService implements IRemoteInventarioRService {
    @EJB
    IInventarioService inventarioService;

    @Override
    public void agregarInventario(InventarioR inventario) {
        inventarioService.agregarInventario(inventario);
    }

    @Override
    public void actualizarInventario(InventarioR inventario) {
        inventarioService.actualizarInventario(inventario);
    }

    @Override
    public void eliminarInventario(Long id) {
        inventarioService.eliminarInventario(id);
    }

    @Override
    public InventarioR obtenerInventario(Long id) {
        return inventarioService.obtenerInventario(id);
    }

    @Override
    public List<InventarioR> obtenerTodosInventarios() {
        return inventarioService.obtenerTodosInventarios();
    }

    @Override
    public InventarioR obtenerInvetarioporIngrediente(Long id) {
        return inventarioService.obtenerInvetarioporIngrediente(id);
    }
}
