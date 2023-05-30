package com.example.negociorestaurante.Services.imp;

import com.example.entidades.PlatoPedido;
import com.example.negociorestaurante.ServiceLocator.IServiceLocator;
import com.example.negociorestaurante.Services.intf.IServicePlatoPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePlatoPedido implements IServicePlatoPedido {
    @Autowired
    @Qualifier("serviceLocator")
    private IServiceLocator serviceLocator;

    @Override
    public void agregarPlatoPedido(PlatoPedido platoPedido) throws Exception {
        serviceLocator.getRemotePlatoPedidoService().agregarPlatoPedido(platoPedido);
    }

    @Override
    public void actualizarPlatoPedido(PlatoPedido platoPedido) throws Exception {
        serviceLocator.getRemotePlatoPedidoService().actualizarPlatoPedido(platoPedido);
    }

    @Override
    public void eliminarPlatoPedido(Long id) throws Exception {
        serviceLocator.getRemotePlatoPedidoService().eliminarPlatoPedido(id);
    }

    @Override
    public PlatoPedido obtenerPlatoPedido(Long id) throws Exception {
        return serviceLocator.getRemotePlatoPedidoService().obtenerPlatoPedido(id);
    }

    @Override
    public List<PlatoPedido> obtenerTodosPlatoPedidos() throws Exception {
        return serviceLocator.getRemotePlatoPedidoService().obtenerTodosPlatoPedidos();
    }

    @Override
    public List<PlatoPedido> obtenerTodosPlatoPorPedido(long id) throws Exception {
        return serviceLocator.getRemotePlatoPedidoService().obtenerTodosPlatoPorPedido(id);
    }
}
