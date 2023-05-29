package com.example.negociorestaurante.Services.imp;

import com.example.entidades.RegistroPago;
import com.example.negociorestaurante.ServiceLocator.IServiceLocator;
import com.example.negociorestaurante.Services.intf.IServiceRegistroPago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceRegistroPago implements IServiceRegistroPago {
    @Autowired
    @Qualifier("serviceLocator")
    private IServiceLocator serviceLocator;
    @Override
    public void agregarRegistroPago(RegistroPago registroPago) {

    }

    @Override
    public void actualizarRegistroPago(RegistroPago registroPago) {

    }

    @Override
    public void eliminarRegistroPago(Long id) {

    }

    @Override
    public RegistroPago obtenerRegistroPago(Long id) {
        return null;
    }

    @Override
    public List<RegistroPago> obtenerTodosRegistroPagos() {
        return null;
    }
}
