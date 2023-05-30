package com.example.negociogeneral.Services.intf;

import com.example.entidades.EstadoEnvio;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import java.io.IOException;

@Service
public interface IServicioEstadoEnvio {
    EstadoEnvio obtenerEstadoEnvioPorNombre(String nombre, String uri) throws NamingException, IOException;
}
