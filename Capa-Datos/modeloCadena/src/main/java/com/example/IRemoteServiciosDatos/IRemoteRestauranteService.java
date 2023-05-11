package com.example.IRemoteServiciosDatos;

import com.example.entidades.Restaurante;
import jakarta.ejb.Remote;

import java.util.List;

@Remote
public interface IRemoteRestauranteService {
    void agregarRestaurante(Restaurante restaurante);
    void actualizarRestaurante(Restaurante restaurante);
    void eliminarRestaurante(Long id);
    Restaurante obtenerRestaurante(Long id);
    List<Restaurante> obtenerTodosRestaurantes();
}
