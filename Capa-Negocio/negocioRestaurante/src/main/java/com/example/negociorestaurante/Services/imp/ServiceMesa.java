package com.example.negociorestaurante.Services.imp;

import com.example.modeloRestaurante.entidades.Mesa;
import com.example.negociorestaurante.ServiceLocator.IServiceLocator;
import com.example.negociorestaurante.Services.intf.IServiceMesa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceMesa implements IServiceMesa {

    @Autowired
    @Qualifier("serviceLocator")
    private IServiceLocator serviceLocator;

    @Override
    public void agregarMesa(Mesa mesa) throws Exception {
        serviceLocator.getRemoteMesaService().agregarMesa(mesa);
    }

    @Override
    public void actualizarMesa(Mesa mesa) throws Exception {
        serviceLocator.getRemoteMesaService().actualizarMesa(mesa);
    }

    @Override
    public void eliminarMesa(Long id) throws Exception {
        serviceLocator.getRemoteMesaService().eliminarMesa(id);
    }

    @Override
    public Mesa obtenerMesa(Long id) throws Exception {
        return serviceLocator.getRemoteMesaService().obtenerMesa(id);
    }

    @Override
    public List<Mesa> obtenerTodasMesas() throws Exception {
        return serviceLocator.getRemoteMesaService().obtenerTodasMesas();
    }
}
