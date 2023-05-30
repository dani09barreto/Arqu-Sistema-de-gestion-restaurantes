package com.example.modeloRestaurante.GestionDatos.Interfaces;

import com.example.entidades.PlatoPedido;
import jakarta.ejb.Local;

import java.util.List;
@Local
public interface IPlatoPedidoService {
    void agregarPlatoPedido(PlatoPedido platoPedido);
    void actualizarPlatoPedido(PlatoPedido platoPedido);
    void eliminarPlatoPedido(Long id);
    PlatoPedido obtenerPlatoPedido(Long id);
    List<PlatoPedido> obtenerTodosPlatoPedidos();
    List<PlatoPedido> obtenerTodosPlatoPorPedido(long id);
}
