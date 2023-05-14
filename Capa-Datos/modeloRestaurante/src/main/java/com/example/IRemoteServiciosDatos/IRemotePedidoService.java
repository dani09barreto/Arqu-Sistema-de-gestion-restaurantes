package com.example.IRemoteServiciosDatos;

import com.example.entidades.Pedido;
import jakarta.ejb.Remote;

import java.util.List;
@Remote
public interface IRemotePedidoService {
    void agregarPedido(Pedido pedido);
    void actualizarPedido(Pedido pedido);
    void eliminarPedido(Long id);
    Pedido obtenerPedido(Long id);
    List<Pedido> obtenerTodosPedidos();
}
