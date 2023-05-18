package com.example.modeloGeneral.GestionDatos.intf;

import com.example.entidades.Bodega;
import com.example.entidades.Inventario;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface IInventarioService {
    void agregarInventario(Inventario inventario);
    void actualizarInventario(Inventario inventario);
    void eliminarInventario(Long id);
    Inventario obtenerInventario(Long id);
    List <Inventario> obtenerTodosInventarioPorBodega(Bodega bodega);
}
