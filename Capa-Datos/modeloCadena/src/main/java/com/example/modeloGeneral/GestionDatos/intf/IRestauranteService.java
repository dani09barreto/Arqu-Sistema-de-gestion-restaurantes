package com.example.modeloGeneral.GestionDatos.intf;

import com.example.entidades.Restaurante;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface IRestauranteService {
    void agregarRestaurante(Restaurante restaurante);
    void actualizarRestaurante(Restaurante restaurante);
    void eliminarRestaurante(Long id);
    Restaurante obtenerRestaurante(Long id);
    List <Restaurante> obtenerTodosRestaurantes();
}
