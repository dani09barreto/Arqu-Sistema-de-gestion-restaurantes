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
    public void agregarInventario(Inventario inventario, String uri) throws NamingException, IOException {
        serviceLocator.getRemoteInventarioService(uri).agregarInventario(inventario);
    }

    @Override
    public void actualizarInventario(Inventario inventario, String uri) throws NamingException, IOException {
        serviceLocator.getRemoteInventarioService(uri).actualizarInventario(inventario);
    }

    @Override
    public void eliminarInventario(Long id, String uri) throws NamingException, IOException {
        serviceLocator.getRemoteInventarioService(uri).eliminarInventario(id);
    }

    @Override
    public Inventario obtenerInventario(Long id, String uri) throws NamingException, IOException {
        return serviceLocator.getRemoteInventarioService(uri).obtenerInventario(id);
    }

    @Override
    public List<Inventario> obtenerTodosInventarioPorBodega(Bodega bodega, int page, int pageSize, String uri) throws NamingException, IOException {
        return serviceLocator.getRemoteInventarioService(uri).obtenerTodosInventarioPorBodega(bodega, page, pageSize);
    }

    @Override
    public Inventario obtenerTodosInventarioPorBodegaPorIngrediente(Bodega bodega, Ingrediente ingrediente, String uri) throws NamingException, IOException {
        return serviceLocator.getRemoteInventarioService(uri).obtenerTodosInventarioPorBodegaPorIngrediente(bodega, ingrediente);
    }

    @Override
    public EnvioInventario agregarEnvioInventario(EnvioInventario envioInventario, List<CantidadIngrediente> ingredientesInventario, String uri) throws NamingException, IOException {
        EnvioInventario en = serviceLocator.getRemoteEnvioInventarioService(uri).agregarEnvioInventario(envioInventario);
        for (CantidadIngrediente cantidadIngrediente : ingredientesInventario) {
            cantidadIngrediente.setEnvioInventario(en);
            serviceLocator.getRemoteCantidadIngredienteService(uri).agregarCantidadIngrediente(cantidadIngrediente);
        }
        return en;
    }

    @Override
    public EnvioInventario obtenerEnvioInventario(Long id, String uri) throws NamingException, IOException {
        return serviceLocator.getRemoteEnvioInventarioService(uri).obtenerEnvioInventario(id);
    }

    @Override
    public void actualizarEnvioInventario(Long idInventario, String nameEstado, String uri) throws NamingException, IOException {
        serviceLocator.getRemoteEnvioInventarioService(uri).actualizarEnvioInventario(idInventario, nameEstado);
    }
}