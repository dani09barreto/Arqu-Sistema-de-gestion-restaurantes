package com.example.modeloGeneral.RemoteServiciosData;

import com.example.IRemoteServiciosDatos.IRemoteRestauranteService;
import com.example.modeloGeneral.GestionDatos.intf.IRestauranteService;
import com.example.entidades.Restaurante;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class RemoteRestauranteService implements IRemoteRestauranteService {

    @EJB
    IRestauranteService restauranteService;

    @Override
    public void agregarRestaurante(Restaurante restaurante) {
        restauranteService.agregarRestaurante(restaurante);
    }

    @Override
    public void actualizarRestaurante(Restaurante restaurante) {
        restauranteService.actualizarRestaurante(restaurante);
    }

    @Override
    public void eliminarRestaurante(Long id) {
        restauranteService.eliminarRestaurante(id);
    }

    @Override
    public Restaurante obtenerRestaurante(Long id) {
        return restauranteService.obtenerRestaurante(id);
    }

    @Override
    public List<Restaurante> obtenerTodosRestaurantes() {
        return restauranteService.obtenerTodosRestaurantes();
    }
}
