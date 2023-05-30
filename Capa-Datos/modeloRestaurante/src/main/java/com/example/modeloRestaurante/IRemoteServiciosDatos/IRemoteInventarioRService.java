package com.example.IRemoteServiciosDatos;

import com.example.entidades.InventarioR;
import jakarta.ejb.Remote;

import java.util.List;
@Remote
public interface IRemoteInventarioRService {
    void agregarInventario(InventarioR inventario);
    void actualizarInventario(InventarioR inventario);
    void eliminarInventario(Long id);
    InventarioR obtenerInventario(Long id);
    List<InventarioR> obtenerTodosInventarios();
    InventarioR obtenerInvetarioporIngrediente(Long id);
}
