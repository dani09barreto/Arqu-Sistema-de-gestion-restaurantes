package com.example.negociorestaurante.Services.intf;

import com.example.entidades.PlatoPedido;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServicePlatoPedido {
    void agregarPlatoPedido(PlatoPedido platoPedido) throws Exception;
    void actualizarPlatoPedido(PlatoPedido platoPedido) throws Exception;
    void eliminarPlatoPedido(Long id) throws Exception;
    PlatoPedido obtenerPlatoPedido(Long id) throws Exception;
    List<PlatoPedido> obtenerTodosPlatoPedidos() throws Exception;
    List<PlatoPedido> obtenerTodosPlatoPorPedido(long id) throws Exception;
}
