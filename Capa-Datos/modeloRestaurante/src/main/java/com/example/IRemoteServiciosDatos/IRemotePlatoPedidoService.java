package com.example.IRemoteServiciosDatos;

import com.example.entidades.PlatoPedido;
import jakarta.ejb.Remote;

import java.util.List;
@Remote
public interface IRemotePlatoPedidoService {
    void agregarPlatoPedido(PlatoPedido platoPedido);
    void actualizarPlatoPedido(PlatoPedido platoPedido);
    void eliminarPlatoPedido(Long id);
    PlatoPedido obtenerPlatoPedido(Long id);
    List<PlatoPedido> obtenerTodosPlatoPedidos();
}
