package com.example.IRemoteServiciosDatos;

import com.example.entidades.Pedido;

import java.util.List;

public interface IRemotePedidoService {
    void agregarPedido(Pedido pedido);
    void actualizarPedido(Pedido pedido);
    void eliminarPedido(Long id);
    Pedido obtenerPedido(Long id);
    List<Pedido> obtenerTodosPedidos();
}
