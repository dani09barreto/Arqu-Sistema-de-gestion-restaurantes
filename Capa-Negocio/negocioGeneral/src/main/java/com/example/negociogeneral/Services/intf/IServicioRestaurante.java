package com.example.negociogeneral.Services.intf;

import com.example.entidades.Restaurante;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServicioRestaurante {
    void agregarRestaurante(Restaurante restaurante);
    void actualizarRestaurante(Restaurante restaurante);
    void eliminarRestaurante(Long id);
    Restaurante obtenerRestaurante(Long id);
    List<Restaurante> obtenerTodosRestaurantes();
}
