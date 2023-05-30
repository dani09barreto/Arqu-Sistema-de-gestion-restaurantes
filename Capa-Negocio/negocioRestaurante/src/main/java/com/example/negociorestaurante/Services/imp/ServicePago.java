package com.example.negociorestaurante.Services.imp;

import com.example.modeloRestaurante.entidades.Pago;
import com.example.negociorestaurante.ServiceLocator.IServiceLocator;
import com.example.negociorestaurante.Services.intf.IServicePago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServicePago implements IServicePago {
    @Autowired
    @Qualifier("serviceLocator")
    private IServiceLocator serviceLocator;

    @Override
    public void agregarPago(Pago pago) throws Exception {
        serviceLocator.getRemotePagoService().agregarPago(pago);
    }

    @Override
    public void actualizarPago(Pago pago) throws Exception {
        serviceLocator.getRemotePagoService().actualizarPago(pago);
    }

    @Override
    public void eliminarPago(Long id) throws Exception {
        serviceLocator.getRemotePagoService().eliminarPago(id);
    }

    @Override
    public Pago obtenerPago(Long id) throws Exception {
        return serviceLocator.getRemotePagoService().obtenerPago(id);
    }

    @Override
    public List<Pago> obtenerTodosPagos() throws Exception {
        return serviceLocator.getRemotePagoService().obtenerTodosPagos();
    }
}
