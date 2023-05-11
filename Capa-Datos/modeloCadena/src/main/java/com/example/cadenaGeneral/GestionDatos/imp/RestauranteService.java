package com.example.cadenaGeneral.GestionDatos.imp;

import com.example.cadenaGeneral.GestionDatos.intf.IRestauranteService;
import com.example.entidades.Restaurante;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class RestauranteService implements IRestauranteService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void agregarRestaurante(Restaurante restaurante) {
        entityManager.persist(restaurante);
    }

    @Override
    public void actualizarRestaurante(Restaurante restaurante) {
        entityManager.merge(restaurante);
    }

    @Override
    public void eliminarRestaurante(Long id) {
        Restaurante restaurante = obtenerRestaurante(id);
        if (restaurante != null) {
            entityManager.remove(restaurante);
        }
    }

    @Override
    public Restaurante obtenerRestaurante(Long id) {
        return entityManager.find(Restaurante.class, id);
    }

    @Override
    public List<Restaurante> obtenerTodosRestaurantes() {
        return entityManager.createQuery("SELECT r FROM Restaurante r", Restaurante.class)
                .getResultList();
    }
}
