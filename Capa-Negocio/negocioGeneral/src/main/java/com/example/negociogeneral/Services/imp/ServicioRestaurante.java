package com.example.negociogeneral.Services.imp;

import com.example.entidades.Restaurante;
import com.example.negociogeneral.ServiceLocator.IServiceLocator;
import com.example.negociogeneral.Services.intf.IServicioRestaurante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import java.io.IOException;
import java.util.List;

@Service
public class ServicioRestaurante implements IServicioRestaurante {

    @Autowired
    @Qualifier("serviceLocator")
    private IServiceLocator serviceLocator;

    @Override
    public void agregarRestaurante(Restaurante restaurante, String uri) {

    }

    @Override
    public void actualizarRestaurante(Restaurante restaurante, String uri) {

    }

    @Override
    public void eliminarRestaurante(Long id, String uri) {

    }

    @Override
    public Restaurante obtenerRestaurante(Long id, String uri) throws NamingException, IOException {
        return serviceLocator.getRemoteRestauranteService(uri).obtenerRestaurante(id);
    }

    @Override
    public List<Restaurante> obtenerTodosRestaurantes(String uri) throws NamingException, IOException {
        return serviceLocator.getRemoteRestauranteService(uri).obtenerTodosRestaurantes();
    }
}
