package com.example.modeloRestaurante.GestionDatos.Implementacion;

import com.example.entidades.IngredientePlato;
import com.example.modeloRestaurante.GestionDatos.Interfaces.IIngredientePlatoService;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class IngredientePlatoService implements IIngredientePlatoService {
    @PersistenceContext(name = "myPersistenceUnit")
    private EntityManager entityManager;

    @Override
    public void agregarIngredientePlato(IngredientePlato plato) {
        entityManager.persist(plato);
    }

    @Override
    public void actualizarIngredientePlato(IngredientePlato plato) {
        entityManager.merge(plato);
    }

    @Override
    public void eliminarIngredientePlato(Long id) {
        IngredientePlato ingr = obtenerIngredientePlato(id);
        if (ingr != null) {
            entityManager.remove(ingr);
        }
    }

    @Override
    public IngredientePlato obtenerIngredientePlato(Long id) {
        return entityManager.find(IngredientePlato.class,id);
    }

    @Override
    public List<IngredientePlato> obtenerTodosIngredientePlato() {
        return entityManager.createQuery("SELECT I FROM IngredientePlato I", IngredientePlato.class).getResultList();
    }
}
