package com.example.negociorestaurante.Services.intf;


import com.example.modeloRestaurante.entidades.Inventario;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IServiceInventario {
    void agregarInventario(Inventario inventario) throws Exception;
    void actualizarInventario(Inventario inventario) throws Exception;
    void eliminarInventario(Long id) throws Exception;
    Inventario obtenerInventario(Long id) throws Exception;
    List<Inventario> obtenerTodosInventarios() throws Exception;
    Inventario obtenerInvetarioporIngrediente(Long id) throws Exception;
}