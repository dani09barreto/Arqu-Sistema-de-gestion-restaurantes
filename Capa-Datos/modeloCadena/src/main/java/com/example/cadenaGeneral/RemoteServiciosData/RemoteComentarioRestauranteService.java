package com.example.cadenaGeneral.RemoteServiciosData;

import com.example.IRemoteServiciosDatos.IRemoteComentarioRestauranteService;
import com.example.cadenaGeneral.GestionDatos.intf.IComentarioRestauranteService;
import com.example.cadenaGeneral.GestionDatos.intf.IRestauranteService;
import com.example.entidades.ComentarioRestaurante;
import com.example.entidades.Restaurante;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class RemoteComentarioRestauranteService implements IRemoteComentarioRestauranteService {

    @EJB
    IComentarioRestauranteService comentarioRestauranteService;
    @EJB
    IRestauranteService restauranteService;

    @Override
    public void agregarComentarioRestaurante(ComentarioRestaurante comentarioRestaurante) {
        comentarioRestauranteService.agregarComentarioRestaurante(comentarioRestaurante);
    }

    @Override
    public void actualizarComentarioRestaurante(ComentarioRestaurante comentarioRestaurante) {
        comentarioRestauranteService.actualizarComentarioRestaurante(comentarioRestaurante);
    }

    @Override
    public void eliminarComentarioRestaurante(Long id) {
        comentarioRestauranteService.eliminarComentarioRestaurante(id);
    }

    @Override
    public ComentarioRestaurante obtenerComentarioRestaurante(Long id) {
        return comentarioRestauranteService.obtenerComentarioRestaurante(id);
    }

    @Override
    public List<ComentarioRestaurante> obtenerTodosComentariosRestaurantePorRestaurante(Long Restauranteid) {
        Restaurante restaurante = restauranteService.obtenerRestaurante(Restauranteid);
        return comentarioRestauranteService.obtenerTodosComentariosRestaurantePorRestaurante(restaurante);
    }

}
