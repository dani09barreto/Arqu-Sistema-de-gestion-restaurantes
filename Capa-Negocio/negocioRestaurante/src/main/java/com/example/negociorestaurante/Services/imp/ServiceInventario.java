package com.example.negociorestaurante.Services.imp;

<<<<<<< HEAD
import com.example.entidades.Inventario;
import com.example.entidades.InventarioR;
=======

import com.example.modeloRestaurante.entidades.Inventario;
>>>>>>> develop
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
<<<<<<< HEAD
    public void agregarInventario(InventarioR inventario) throws Exception {
=======
    public void agregarInventario(Inventario inventario) throws Exception {
>>>>>>> develop
        serviceLocator.getRemoteInventarioService().agregarInventario(inventario);
    }

    @Override
<<<<<<< HEAD
    public void actualizarInventario(InventarioR inventario) throws Exception {
=======
    public void actualizarInventario(Inventario inventario) throws Exception {
>>>>>>> develop
        serviceLocator.getRemoteInventarioService().actualizarInventario(inventario);
    }

    @Override
    public void eliminarInventario(Long id) throws Exception {
        serviceLocator.getRemoteInventarioService().eliminarInventario(id);
    }

    @Override
<<<<<<< HEAD
    public InventarioR obtenerInventario(Long id) throws Exception {
=======
    public Inventario obtenerInventario(Long id) throws Exception {
>>>>>>> develop
        return serviceLocator.getRemoteInventarioService().obtenerInventario(id);
    }

    @Override
<<<<<<< HEAD
    public List<InventarioR> obtenerTodosInventarios() throws Exception {
=======
    public List<Inventario> obtenerTodosInventarios() throws Exception {
>>>>>>> develop
        return serviceLocator.getRemoteInventarioService().obtenerTodosInventarios();
    }

    @Override
<<<<<<< HEAD
    public InventarioR obtenerInvetarioporIngrediente(Long id) throws Exception {
=======
    public Inventario obtenerInvetarioporIngrediente(Long id) throws Exception {
>>>>>>> develop
        return serviceLocator.getRemoteInventarioService().obtenerInvetarioporIngrediente(id);
    }
}
