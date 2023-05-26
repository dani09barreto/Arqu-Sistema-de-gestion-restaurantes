package com.example.modeloRestaurante.GestionDatos.Interfaces;

import com.example.entidades.Inventario;
import jakarta.ejb.Local;

import java.util.List;
@Local
public interface IInventarioService {
    void agregarInventario(Inventario inventario);
    void actualizarInventario(Inventario inventario);
    void eliminarInventario(Long id);
    Inventario obtenerInventario(Long id);
    List<Inventario> obtenerTodosInventarios();
}
