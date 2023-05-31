package com.example.negociorestaurante.Services.imp;

import com.example.modeloRestaurante.entidades.Adicionales;
import com.example.negociorestaurante.ServiceLocator.IServiceLocator;
import com.example.negociorestaurante.Services.intf.IServiceAdicionales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceAdicionales implements IServiceAdicionales {
    @Autowired
    @Qualifier("serviceLocator")
    private IServiceLocator serviceLocator;
    @Override
    public void agregarAdicionales(Adicionales adicionales) throws Exception {
        serviceLocator.getRemoteAdicionalesService().agregarAdicionales(adicionales);
    }

    @Override
    public void actualizarAdicionales(Adicionales adicionales) throws Exception {
        serviceLocator.getRemoteAdicionalesService().actualizarAdicionales(adicionales);
    }

    @Override
    public void eliminarAdicionales(Long id) {

    }

    @Override
    public Adicionales obtenerAdicionales(Long id) {
        return null;
    }

    @Override
    public List<Adicionales> obtenerTodasAdicionales() {
        return null;
    }

    @Override
    public Adicionales obtenerAdicionalporNombre(String nombre) {
       // return serviceLocator.getRemoteAdicionalesService();
        return null;
    }
}
