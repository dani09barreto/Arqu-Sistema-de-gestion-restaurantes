package com.example.modeloRestaurante.RemoteServiciosData;

import com.example.IRemoteServiciosDatos.IRemoteEstadoPedidoService;
import com.example.entidades.EstadoPedido;
import com.example.modeloRestaurante.GestionDatos.Interfaces.IEstadoPedidoService;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class RemoteEstadoPedidoService implements IRemoteEstadoPedidoService {
    @EJB
    IEstadoPedidoService estadoPedidoService;

    @Override
    public void agregarEstadoPedido(EstadoPedido estadoPedido) {
        estadoPedidoService.agregarEstadoPedido(estadoPedido);
    }

    @Override
    public void actualizarEstadoPedido(EstadoPedido estadoPedido) {
        estadoPedidoService.actualizarEstadoPedido(estadoPedido);
    }

    @Override
    public void eliminarEstadoPedido(Long id) {
        estadoPedidoService.eliminarEstadoPedido(id);
    }

    @Override
    public EstadoPedido obtenerEstadoPedido(Long id) {
        return estadoPedidoService.obtenerEstadoPedido(id);
    }

    @Override
    public List<EstadoPedido> obtenerTodosEstadosPedido() {
        return estadoPedidoService.obtenerTodosEstadosPedido();
    }
}
