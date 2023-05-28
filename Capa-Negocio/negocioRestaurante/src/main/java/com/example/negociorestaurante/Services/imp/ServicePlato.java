package com.example.negociorestaurante.Services.imp;

import com.example.entidades.PlatoR;
import com.example.negociorestaurante.ServiceLocator.IServiceLocator;
import com.example.negociorestaurante.Services.intf.IServicePlato;
import jakarta.ejb.Stateless;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePlato implements IServicePlato {
    @Autowired
    @Qualifier("serviceLocator")
    private IServiceLocator serviceLocator;

    @Override
    public void agregarPlato(PlatoR plato) throws Exception {
        serviceLocator.getRemotePlatoService().agregarPlato(plato);
    }

    @Override
    public void actualizarPlato(PlatoR plato) throws Exception {
        serviceLocator.getRemotePlatoService().actualizarPlato(plato);
    }

    @Override
    public void eliminarPlato(Long id) throws Exception {
        serviceLocator.getRemotePlatoService().eliminarPlato(id);
    }

    @Override
    public PlatoR obtenerPlato(Long id) throws Exception {
        return serviceLocator.getRemotePlatoService().obtenerPlato(id);
    }

    @Override
    public List<PlatoR> obtenerTodosPlato() throws Exception {
        return serviceLocator.getRemotePlatoService().obtenerTodosPlato();
    }
}
