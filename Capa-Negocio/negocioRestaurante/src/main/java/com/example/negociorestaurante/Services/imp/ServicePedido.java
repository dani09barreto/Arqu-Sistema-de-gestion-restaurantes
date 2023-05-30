package com.example.negociorestaurante.Services.imp;

import com.example.entidades.Pedido;
import com.example.negociorestaurante.ServiceLocator.IServiceLocator;
import com.example.negociorestaurante.Services.intf.IServicePedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePedido implements IServicePedido {
    @Autowired
    @Qualifier("serviceLocator")
    private IServiceLocator serviceLocator;

    @Override
    public Pedido agregarPedido(Pedido pedido) throws Exception {
        return serviceLocator.getRemotePedidoService().agregarPedido(pedido);
    }

    @Override
    public void actualizarPedido(Pedido pedido) throws Exception {
        serviceLocator.getRemotePedidoService().actualizarPedido(pedido);
    }

    @Override
    public void eliminarPedido(Long id) throws Exception {
        serviceLocator.getRemotePedidoService().eliminarPedido(id);
    }

    @Override
    public Pedido obtenerPedido(Long id) throws Exception {
        return serviceLocator.getRemotePedidoService().obtenerPedido(id);
    }

    @Override
    public List<Pedido> obtenerTodosPedidos() throws Exception {
        return serviceLocator.getRemotePedidoService().obtenerTodosPedidos();
    }
}
