package com.example.modeloRestaurante.GestionDatos.Interfaces;

import com.example.entidades.Pedido;
import jakarta.ejb.Local;

import java.util.List;
@Local
public interface IPedidoService {
    Pedido agregarPedido(Pedido pedido);
    void actualizarPedido(Pedido pedido);
    void eliminarPedido(Long id);
    Pedido obtenerPedido(Long id);
    List<Pedido> obtenerTodosPedidos();
}
