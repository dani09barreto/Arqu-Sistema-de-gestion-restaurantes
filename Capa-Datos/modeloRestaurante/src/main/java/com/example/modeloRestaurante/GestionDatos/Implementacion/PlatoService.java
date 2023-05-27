package com.example.modeloRestaurante.GestionDatos.Implementacion;

import com.example.entidades.Plato;
import com.example.modeloRestaurante.GestionDatos.Interfaces.IPlatoService;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class PlatoService implements IPlatoService {
    @PersistenceContext(name = "myPersistenceUnit")
    private EntityManager entityManager;
    @Override
    public void agregarPlato(Plato plato) {
        entityManager.persist(plato);
    }

    @Override
    public void actualizarPlato(Plato plato) {
        entityManager.merge(plato);
    }

    @Override
    public void eliminarPlato(Long id) {
        Plato plato = obtenerPlato(id);
        if(plato != null){
            entityManager.remove(plato);
        }
    }

    @Override
    public Plato obtenerPlato(Long id) {
        return entityManager.find(Plato.class,id);
    }

    @Override
    public List<Plato> obtenerTodosPlato() {
        return entityManager.createQuery("SELECT p FROM Plato p",Plato.class).getResultList();
    }
}
