package com.example.negociogeneral.Services.intf;

import com.example.entidades.Restaurante;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import java.io.IOException;
import java.util.List;

@Service
public interface IServicioRestaurante {
    void agregarRestaurante(Restaurante restaurante, String uri);
    void actualizarRestaurante(Restaurante restaurante, String uri);
    void eliminarRestaurante(Long id, String uri);
    Restaurante obtenerRestaurante(Long id, String uri) throws NamingException, IOException;
    List<Restaurante> obtenerTodosRestaurantes(String uri) throws NamingException, IOException;
}
