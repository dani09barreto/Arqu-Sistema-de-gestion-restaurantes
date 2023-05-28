package com.example.negociorestaurante.Services.intf;

import com.example.entidades.Pedido;

import java.util.List;

public interface IServicePedido {
    void agregarPedido(Pedido pedido) throws Exception;
    void actualizarPedido(Pedido pedido) throws Exception;
    void eliminarPedido(Long id) throws Exception;
    Pedido obtenerPedido(Long id) throws Exception;
    List<Pedido> obtenerTodosPedidos() throws Exception;
}
