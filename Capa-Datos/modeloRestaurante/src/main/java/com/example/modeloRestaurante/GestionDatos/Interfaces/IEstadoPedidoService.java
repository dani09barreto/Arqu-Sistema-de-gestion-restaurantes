package com.example.modeloRestaurante.GestionDatos.Interfaces;

import com.example.entidades.EstadoPedido;

import java.util.List;

public interface IEstadoPedidoService {
    void agregarEstadoPedido(EstadoPedido estadoPedido);
    void actualizarEstadoPedido(EstadoPedido estadoPedido);
    void eliminarEstadoPedido(Long id);
    EstadoPedido obtenerEstadoPedido(Long id);
    List<EstadoPedido> obtenerTodosEstadosPedido();
}
