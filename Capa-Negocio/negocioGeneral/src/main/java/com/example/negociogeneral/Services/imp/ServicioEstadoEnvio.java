package com.example.negociogeneral.Services.imp;

import com.example.negociogeneral.ServiceLocator.IServiceLocator;
import com.example.negociogeneral.Services.intf.IServicioEstadoEnvio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import java.io.IOException;

@Service
public class ServicioEstadoEnvio implements IServicioEstadoEnvio {
    @Autowired
    @Qualifier("serviceLocator")
    private IServiceLocator serviceLocator;

    @Override
    public com.example.entidades.EstadoEnvio obtenerEstadoEnvioPorNombre(String nombre) throws NamingException, IOException {
        return serviceLocator.getRemoteEstadoEnvioService().obtenerEstadoEnvioPorNombre(nombre);
    }
}
