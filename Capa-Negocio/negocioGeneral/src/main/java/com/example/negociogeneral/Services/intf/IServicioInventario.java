package com.example.negociogeneral.Services.intf;

import com.example.entidades.*;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import java.io.IOException;
import java.util.List;

@Service
public interface IServicioInventario {
    void agregarInventario(Inventario inventario, String uri) throws NamingException, IOException;
    void actualizarInventario(Inventario inventario, String uri) throws NamingException, IOException;
    void eliminarInventario(Long id, String uri) throws NamingException, IOException;
    Inventario obtenerInventario(Long id, String uri) throws NamingException, IOException;
    List<Inventario> obtenerTodosInventarioPorBodega(Bodega bodega, int page, int pageSize, String uri) throws NamingException, IOException;
    Inventario obtenerTodosInventarioPorBodegaPorIngrediente(Bodega bodega, Ingrediente ingrediente, String uri) throws NamingException, IOException;
    EnvioInventario agregarEnvioInventario(EnvioInventario envioInventario, List <CantidadIngrediente> ingredientesInventario, String uri) throws NamingException, IOException;
    EnvioInventario obtenerEnvioInventario(Long id, String uri) throws NamingException, IOException;
    void actualizarEnvioInventario(Long idInventario, String nameEstado, String uri) throws NamingException, IOException;
}
