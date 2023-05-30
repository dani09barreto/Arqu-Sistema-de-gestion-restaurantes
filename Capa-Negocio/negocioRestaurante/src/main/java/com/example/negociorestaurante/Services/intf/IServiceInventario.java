package com.example.negociorestaurante.Services.intf;

<<<<<<< HEAD
import com.example.entidades.Inventario;
import com.example.entidades.InventarioR;
=======

import com.example.modeloRestaurante.entidades.Inventario;
>>>>>>> develop
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IServiceInventario {
<<<<<<< HEAD
    void agregarInventario(InventarioR inventario) throws Exception;
    void actualizarInventario(InventarioR inventario) throws Exception;
    void eliminarInventario(Long id) throws Exception;
    InventarioR obtenerInventario(Long id) throws Exception;
    List<InventarioR> obtenerTodosInventarios() throws Exception;
    InventarioR obtenerInvetarioporIngrediente(Long id) throws Exception;
=======
    void agregarInventario(Inventario inventario) throws Exception;
    void actualizarInventario(Inventario inventario) throws Exception;
    void eliminarInventario(Long id) throws Exception;
    Inventario obtenerInventario(Long id) throws Exception;
    List<Inventario> obtenerTodosInventarios() throws Exception;
    Inventario obtenerInvetarioporIngrediente(Long id) throws Exception;
>>>>>>> develop
}