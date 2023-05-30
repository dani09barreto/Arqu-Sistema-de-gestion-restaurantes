package com.example.negociorestaurante.Services.intf;

import com.example.modeloRestaurante.entidades.EstadoPedido;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IServiceEstadoPedido {
    void agregarEstadoPedido(EstadoPedido estadoPedido);
    void actualizarEstadoPedido(EstadoPedido estadoPedido);
    void eliminarEstadoPedido(Long id);
    EstadoPedido obtenerEstadoPedido(Long id);
    List<EstadoPedido> obtenerTodosEstadosPedido();
    EstadoPedido obtenerEstadoPedidoPorEstado(String estado) throws Exception;
}
