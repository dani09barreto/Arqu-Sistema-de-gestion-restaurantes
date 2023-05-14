package com.example.IRemoteServiciosDatos;

import com.example.entidades.EstadoPedido;

import java.util.List;

public interface IRemoteEstadoPedidoService {
    void agregarEstadoPedido(EstadoPedido estadoPedido);
    void actualizarEstadoPedido(EstadoPedido estadoPedido);
    void eliminarEstadoPedido(Long id);
    EstadoPedido obtenerEstadoPedido(Long id);
    List<EstadoPedido> obtenerTodosEstadosPedido();
}
