package com.example.modeloRestaurante.GestionDatos.Interfaces;

import com.example.entidades.InventarioR;
import jakarta.ejb.Local;

import java.util.List;
@Local
public interface IInventarioService {
    void agregarInventario(InventarioR inventario);
    void actualizarInventario(InventarioR inventario);
    void eliminarInventario(Long id);
    InventarioR obtenerInventario(Long id);
    List<InventarioR> obtenerTodosInventarios();
}
