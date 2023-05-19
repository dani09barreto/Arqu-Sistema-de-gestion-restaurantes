package com.example.negociogeneral.Services.intf;

import com.example.entidades.*;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import java.io.IOException;
import java.util.List;

@Service
public interface IServicioInventario {
    void agregarInventario(Inventario inventario) throws NamingException, IOException;
    void actualizarInventario(Inventario inventario) throws NamingException, IOException;
    void eliminarInventario(Long id) throws NamingException, IOException;
    Inventario obtenerInventario(Long id) throws NamingException, IOException;
    List<Inventario> obtenerTodosInventarioPorBodega(Bodega bodega, int page, int pageSize) throws NamingException, IOException;
    Inventario obtenerTodosInventarioPorBodegaPorIngrediente(Bodega bodega, Ingrediente ingrediente) throws NamingException, IOException;
    void agregarEnvioInventario(EnvioInventario envioInventario, List <CantidadIngrediente> ingredientesInventario) throws NamingException, IOException;
}
