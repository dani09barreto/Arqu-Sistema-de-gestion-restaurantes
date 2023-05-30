package com.example.negociorestaurante.Services.imp;

import com.example.entidades.Inventario;
import com.example.entidades.InventarioR;
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
    public void agregarInventario(InventarioR inventario) throws Exception {
        serviceLocator.getRemoteInventarioService().agregarInventario(inventario);
    }

    @Override
    public void actualizarInventario(InventarioR inventario) throws Exception {
        serviceLocator.getRemoteInventarioService().actualizarInventario(inventario);
    }

    @Override
    public void eliminarInventario(Long id) throws Exception {
        serviceLocator.getRemoteInventarioService().eliminarInventario(id);
    }

    @Override
    public InventarioR obtenerInventario(Long id) throws Exception {
        return serviceLocator.getRemoteInventarioService().obtenerInventario(id);
    }

    @Override
    public List<InventarioR> obtenerTodosInventarios() throws Exception {
        return serviceLocator.getRemoteInventarioService().obtenerTodosInventarios();
    }

    @Override
    public InventarioR obtenerInvetarioporIngrediente(Long id) throws Exception {
        return serviceLocator.getRemoteInventarioService().obtenerInvetarioporIngrediente(id);
    }
}
