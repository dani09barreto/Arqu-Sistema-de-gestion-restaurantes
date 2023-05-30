package com.example.negociorestaurante.Services.intf;

<<<<<<< HEAD
import com.example.entidades.Pedido;
=======
import com.example.modeloRestaurante.entidades.Pedido;
>>>>>>> develop

import java.util.List;

public interface IServicePedido {
    Pedido agregarPedido(Pedido pedido) throws Exception;
    void actualizarPedido(Pedido pedido) throws Exception;
    void eliminarPedido(Long id) throws Exception;
    Pedido obtenerPedido(Long id) throws Exception;
    List<Pedido> obtenerTodosPedidos() throws Exception;
}
