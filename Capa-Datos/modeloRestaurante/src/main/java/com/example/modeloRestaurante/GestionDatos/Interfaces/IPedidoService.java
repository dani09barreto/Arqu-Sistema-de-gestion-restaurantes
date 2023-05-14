package com.example.modeloRestaurante.GestionDatos.Interfaces;

import com.example.entidades.Pedido;

import java.util.List;

public interface IPedidoService {
    void agregarPedido(Pedido pedido);
    void actualizarPedido(Pedido pedido);
    void eliminarPedido(Long id);
    Pedido obtenerPedido(Long id);
    List<Pedido> obtenerTodosPedidos();
}
