package com.example.negociogeneral.Services.imp;

import com.example.entidades.Restaurante;
import com.example.negociogeneral.ServiceLocator.IServiceLocator;
import com.example.negociogeneral.Services.intf.IServicioRestaurante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioRestaurante implements IServicioRestaurante {

    @Autowired
    @Qualifier("serviceLocator")
    private IServiceLocator serviceLocator;

    @Override
    public void agregarRestaurante(Restaurante restaurante) {

    }

    @Override
    public void actualizarRestaurante(Restaurante restaurante) {

    }

    @Override
    public void eliminarRestaurante(Long id) {

    }

    @Override
    public Restaurante obtenerRestaurante(Long id) {
        return null;
    }

    @Override
    public List<Restaurante> obtenerTodosRestaurantes() {
        return null;
    }
}
