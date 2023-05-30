package com.example.modeloRestaurante.GestionDatos.Implementacion;

import com.example.entidades.IngredienteR;
import com.example.modeloRestaurante.GestionDatos.Interfaces.IIngredienteService;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
@Stateless
public class IngredienteService implements IIngredienteService {
    @PersistenceContext(name = "myPersistenceUnit")
    private EntityManager entityManager;
    @Override
    public void agregarIngrediente(IngredienteR ingrediente) {
        entityManager.persist(ingrediente);
    }

    @Override
    public void actualizarIngrediente(IngredienteR ingrediente) {
        entityManager.merge(ingrediente);
    }

    @Override
    public void eliminarIngrediente(Long id) {
        IngredienteR ingrediente = obtenerIngrediente(id);
        if (ingrediente != null) {
            entityManager.remove(ingrediente);
        }
    }

    @Override
    public IngredienteR obtenerIngrediente(Long id) {
        return entityManager.find(IngredienteR.class, id);
    }

    @Override
    public List<IngredienteR> obtenerTodosIngredientes() {
        return entityManager.createQuery("SELECT i FROM IngredienteR i", IngredienteR.class).getResultList();
    }
}
