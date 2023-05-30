package com.example.negociorestaurante.Services.imp;

import com.example.entidades.TipoPago;
import com.example.negociorestaurante.ServiceLocator.IServiceLocator;
import com.example.negociorestaurante.Services.intf.IServiceTipoPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceTipoPago implements IServiceTipoPago {
    @Autowired
    @Qualifier("serviceLocator")
    private IServiceLocator serviceLocator;

    @Override
    public void agregarTipoPago(TipoPago tipoPago) throws Exception {
        serviceLocator.getRemoteTipoPagoService().agregarTipoPago(tipoPago);
    }

    @Override
    public void actualizarTipoPago(TipoPago tipoPago) throws Exception {
        serviceLocator.getRemoteTipoPagoService().actualizarTipoPago(tipoPago);
    }

    @Override
    public void eliminarTipoPago(Long id) throws Exception {
        serviceLocator.getRemoteTipoPagoService().eliminarTipoPago(id);
    }

    @Override
    public TipoPago obtenerTipoPago(Long id) throws Exception {
        return serviceLocator.getRemoteTipoPagoService().obtenerTipoPago(id);
    }

    @Override
    public List<TipoPago> obtenerTodosTipoPagos() throws Exception {
        return serviceLocator.getRemoteTipoPagoService().obtenerTodosTipoPagos();
    }

    @Override
    public TipoPago obtenerTipoPagoPorNombre(String nombre) throws Exception {
        return serviceLocator.getRemoteTipoPagoService().obtenerTipoPagoPorNombre(nombre);
    }
}
