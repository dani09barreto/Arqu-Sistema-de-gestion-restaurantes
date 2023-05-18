package com.example.IRemoteServiciosDatos;

import com.example.entidades.Bodega;
import com.example.entidades.Inventario;
import jakarta.ejb.Remote;

import java.util.List;

@Remote
public interface IRemoteInventarioService {
    void agregarInventario(Inventario inventario);
    void actualizarInventario(Inventario inventario);
    void eliminarInventario(Long id);
    Inventario obtenerInventario(Long id);
    List<Inventario> obtenerTodosInventarioPorBodega(Bodega bodega);
}
