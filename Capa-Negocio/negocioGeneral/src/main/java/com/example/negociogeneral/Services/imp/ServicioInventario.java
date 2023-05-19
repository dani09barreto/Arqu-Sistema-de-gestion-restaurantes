package com.example.negociogeneral.Services.imp;

import com.example.entidades.*;
import com.example.negociogeneral.ServiceLocator.IServiceLocator;
import com.example.negociogeneral.Services.intf.IServicioInventario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import java.io.IOException;
import java.util.List;

@Service
public class ServicioInventario implements IServicioInventario {

    @Autowired
    @Qualifier("serviceLocator")
    private IServiceLocator serviceLocator;

    @Override
    public void agregarInventario(Inventario inventario) throws NamingException, IOException {
        serviceLocator.getRemoteInventarioService().agregarInventario(inventario);
    }

    @Override
    public void actualizarInventario(Inventario inventario) throws NamingException, IOException {
        serviceLocator.getRemoteInventarioService().actualizarInventario(inventario);
    }

    @Override
    public void eliminarInventario(Long id) throws NamingException, IOException {
        serviceLocator.getRemoteInventarioService().eliminarInventario(id);
    }

    @Override
    public Inventario obtenerInventario(Long id) throws NamingException, IOException {
        return serviceLocator.getRemoteInventarioService().obtenerInventario(id);
    }

    @Override
    public List<Inventario> obtenerTodosInventarioPorBodega(Bodega bodega, int page, int pageSize) throws NamingException, IOException {
        return serviceLocator.getRemoteInventarioService().obtenerTodosInventarioPorBodega(bodega, page, pageSize);
    }

    @Override
    public Inventario obtenerTodosInventarioPorBodegaPorIngrediente(Bodega bodega, Ingrediente ingrediente) throws NamingException, IOException {
        return serviceLocator.getRemoteInventarioService().obtenerTodosInventarioPorBodegaPorIngrediente(bodega, ingrediente);
    }

    @Override
    public void agregarEnvioInventario(EnvioInventario envioInventario, List<CantidadIngrediente> ingredientesInventario) throws NamingException, IOException {
        EnvioInventario en = serviceLocator.getRemoteEnvioInventarioService().agregarEnvioInventario(envioInventario);
        for (CantidadIngrediente cantidadIngrediente : ingredientesInventario) {
            cantidadIngrediente.setEnvioInventario(en);
            serviceLocator.getRemoteCantidadIngredienteService().agregarCantidadIngrediente(cantidadIngrediente);
        }
    }
}