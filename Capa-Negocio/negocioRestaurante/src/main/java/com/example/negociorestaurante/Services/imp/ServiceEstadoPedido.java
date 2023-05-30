package com.example.negociorestaurante.Services.imp;

<<<<<<< HEAD
import com.example.entidades.EstadoPedido;
=======
import com.example.modeloRestaurante.entidades.EstadoPedido;
>>>>>>> develop
import com.example.negociorestaurante.ServiceLocator.IServiceLocator;
import com.example.negociorestaurante.Services.intf.IServiceEstadoPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceEstadoPedido implements IServiceEstadoPedido {
    @Autowired
    @Qualifier("serviceLocator")
    private IServiceLocator serviceLocator;
    @Override
    public void agregarEstadoPedido(EstadoPedido estadoPedido) {

    }

    @Override
    public void actualizarEstadoPedido(EstadoPedido estadoPedido) {

    }

    @Override
    public void eliminarEstadoPedido(Long id) {

    }

    @Override
    public EstadoPedido obtenerEstadoPedido(Long id) {
        return null;
    }

    @Override
    public List<EstadoPedido> obtenerTodosEstadosPedido() {
        return null;
    }

    @Override
    public EstadoPedido obtenerEstadoPedidoPorEstado(String estado) throws Exception {
        return serviceLocator.getRemoteEstadoPedidoService().obtenerEstadoPedidoPorEstado(estado);
    }
}
