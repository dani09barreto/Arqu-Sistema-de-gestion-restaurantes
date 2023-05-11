package com.example.cadenaGeneral.GestionDatos.imp;

import com.example.cadenaGeneral.GestionDatos.intf.IComentarioRestauranteService;
import com.example.entidades.ComentarioRestaurante;
import com.example.entidades.Restaurante;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class ComentarioRestauranteService implements IComentarioRestauranteService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void agregarComentarioRestaurante(ComentarioRestaurante comentarioRestaurante) {
        entityManager.persist(comentarioRestaurante);
    }

    @Override
    public void actualizarComentarioRestaurante(ComentarioRestaurante comentarioRestaurante) {
        entityManager.merge(comentarioRestaurante);
    }

    @Override
    public void eliminarComentarioRestaurante(Long id) {
        ComentarioRestaurante comentarioRestaurante = obtenerComentarioRestaurante(id);
        if (comentarioRestaurante != null) {
            entityManager.remove(comentarioRestaurante);
        }
    }

    @Override
    public ComentarioRestaurante obtenerComentarioRestaurante(Long id) {
        return entityManager.find(ComentarioRestaurante.class, id);
    }

    @Override
    public List<ComentarioRestaurante> obtenerTodosComentariosRestaurantePorRestaurante(Restaurante restaurante) {
        return entityManager.createQuery("SELECT c FROM ComentarioRestaurante c WHERE c.restaurante = :restaurante", ComentarioRestaurante.class)
                .setParameter("restaurante", restaurante)
                .getResultList();
    }


}
