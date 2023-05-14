package com.example.modeloRestaurante.GestionDatos.Interfaces;

import com.example.entidades.PlatoPedido;

import java.util.List;

public interface IPlatoPedidoService {
    void agregarPlatoPedido(PlatoPedido platoPedido);
    void actualizarPlatoPedido(PlatoPedido platoPedido);
    void eliminarPlatoPedido(Long id);
    PlatoPedido obtenerPlatoPedido(Long id);
    List<PlatoPedido> obtenerTodosPlatoPedidos();
}
