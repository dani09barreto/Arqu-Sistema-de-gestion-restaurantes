package com.example.negociorestaurante.Services.intf;

import com.example.entidades.Inventario;
import com.example.entidades.InventarioR;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IServiceInventario {
    void agregarInventario(InventarioR inventario) throws Exception;
    void actualizarInventario(InventarioR inventario) throws Exception;
    void eliminarInventario(Long id) throws Exception;
    InventarioR obtenerInventario(Long id) throws Exception;
    List<InventarioR> obtenerTodosInventarios() throws Exception;
}