package com.example.negociorestaurante.Services.imp;


import com.example.modeloRestaurante.entidades.Inventario;
import com.example.negociorestaurante.ServiceLocator.IServiceLocator;
import com.example.negociorestaurante.Services.intf.IServiceInventario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceInventario implements IServiceInventario {

    @Autowired
    @Qualifier("serviceLocator")
    private IServiceLocator serviceLocator;

    @Override
    public void agregarInventario(Inventario inventario) throws Exception {
        serviceLocator.getRemoteInventarioService().agregarInventario(inventario);
    }

    @Override
    public void actualizarInventario(Inventario inventario) throws Exception {
        serviceLocator.getRemoteInventarioService().actualizarInventario(inventario);
    }

    @Override
    public void eliminarInventario(Long id) throws Exception {
        serviceLocator.getRemoteInventarioService().eliminarInventario(id);
    }

    @Override
    public Inventario obtenerInventario(Long id) throws Exception {
        return serviceLocator.getRemoteInventarioService().obtenerInventario(id);
    }

    @Override
    public List<Inventario> obtenerTodosInventarios() throws Exception {
        return serviceLocator.getRemoteInventarioService().obtenerTodosInventarios();
    }

    @Override
    public Inventario obtenerInvetarioporIngrediente(Long id) throws Exception {
        return serviceLocator.getRemoteInventarioService().obtenerInvetarioporIngrediente(id);
    }
}
