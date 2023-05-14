package com.example.modeloGeneral.GestionDatos.intf;

import com.example.entidades.ComentarioRestaurante;
import com.example.entidades.Restaurante;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface IComentarioRestauranteService {
    void agregarComentarioRestaurante(ComentarioRestaurante comentarioRestaurante);
    void actualizarComentarioRestaurante(ComentarioRestaurante comentarioRestaurante);
    void eliminarComentarioRestaurante(Long id);
    ComentarioRestaurante obtenerComentarioRestaurante(Long id);
    List <ComentarioRestaurante> obtenerTodosComentariosRestaurantePorRestaurante(Restaurante restaurante);

}
