package com.example.modeloRestaurante.IRemoteServiciosDatos;

import com.example.modeloRestaurante.entidades.Pedido;
import jakarta.ejb.Remote;

import java.util.List;
@Remote
public interface IRemotePedidoService {
    Pedido agregarPedido(Pedido pedido);
    void actualizarPedido(Pedido pedido);
    void eliminarPedido(Long id);
    Pedido obtenerPedido(Long id);
    List<Pedido> obtenerTodosPedidos();
}