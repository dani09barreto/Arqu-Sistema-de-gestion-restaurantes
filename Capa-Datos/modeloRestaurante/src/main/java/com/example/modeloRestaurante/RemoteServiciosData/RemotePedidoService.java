package com.example.modeloRestaurante.RemoteServiciosData;

import com.example.IRemoteServiciosDatos.IRemotePedidoService;
import com.example.entidades.Pedido;
import com.example.modeloRestaurante.GestionDatos.Interfaces.IPedidoService;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class RemotePedidoService implements IRemotePedidoService {
    @EJB
    IPedidoService pedidoService;

    @Override
    public void agregarPedido(Pedido pedido) {
        pedidoService.agregarPedido(pedido);
    }

    @Override
    public void actualizarPedido(Pedido pedido) {
        pedidoService.actualizarPedido(pedido);
    }

    @Override
    public void eliminarPedido(Long id) {
        pedidoService.eliminarPedido(id);
    }

    @Override
    public Pedido obtenerPedido(Long id) {
        return pedidoService.obtenerPedido(id);
    }

    @Override
    public List<Pedido> obtenerTodosPedidos() {
        return pedidoService.obtenerTodosPedidos();
    }
}
