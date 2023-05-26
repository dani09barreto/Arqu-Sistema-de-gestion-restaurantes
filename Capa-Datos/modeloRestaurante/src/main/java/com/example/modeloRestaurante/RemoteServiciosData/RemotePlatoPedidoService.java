package com.example.modeloRestaurante.RemoteServiciosData;

import com.example.IRemoteServiciosDatos.IRemotePlatoPedidoService;
import com.example.entidades.PlatoPedido;
import com.example.modeloRestaurante.GestionDatos.Interfaces.IPlatoPedidoService;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class RemotePlatoPedidoService implements IRemotePlatoPedidoService {
    @EJB
    IPlatoPedidoService platoPedidoService;

    @Override
    public void agregarPlatoPedido(PlatoPedido platoPedido) {
        platoPedidoService.agregarPlatoPedido(platoPedido);
    }

    @Override
    public void actualizarPlatoPedido(PlatoPedido platoPedido) {
        platoPedidoService.actualizarPlatoPedido(platoPedido);
    }

    @Override
    public void eliminarPlatoPedido(Long id) {
        platoPedidoService.eliminarPlatoPedido(id);
    }

    @Override
    public PlatoPedido obtenerPlatoPedido(Long id) {
        return platoPedidoService.obtenerPlatoPedido(id);
    }

    @Override
    public List<PlatoPedido> obtenerTodosPlatoPedidos() {
        return platoPedidoService.obtenerTodosPlatoPedidos();
    }
}
