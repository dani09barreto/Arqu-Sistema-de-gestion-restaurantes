package com.example.modeloRestaurante.GestionDatos.Interfaces;

import com.example.entidades.EstadoPedido;
import jakarta.ejb.Local;

import java.util.List;
@Local
public interface IEstadoPedidoService {
    void agregarEstadoPedido(EstadoPedido estadoPedido);
    void actualizarEstadoPedido(EstadoPedido estadoPedido);
    void eliminarEstadoPedido(Long id);
    EstadoPedido obtenerEstadoPedido(Long id);
    List<EstadoPedido> obtenerTodosEstadosPedido();
    EstadoPedido obtenerEstadoPedidoPorEstado(String estado);
}
