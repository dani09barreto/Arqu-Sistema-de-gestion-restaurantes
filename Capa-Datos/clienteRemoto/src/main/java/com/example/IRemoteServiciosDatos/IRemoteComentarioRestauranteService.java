package com.example.IRemoteServiciosDatos;

import com.example.entidades.ComentarioRestaurante;
import jakarta.ejb.Remote;

import java.util.List;

@Remote
public interface IRemoteComentarioRestauranteService {
    void agregarComentarioRestaurante(ComentarioRestaurante comentarioRestaurante);
    void actualizarComentarioRestaurante(ComentarioRestaurante comentarioRestaurante);
    void eliminarComentarioRestaurante(Long id);
    ComentarioRestaurante obtenerComentarioRestaurante(Long id);
    List <ComentarioRestaurante> obtenerTodosComentariosRestaurantePorRestaurante(Long Restauranteid);
}
