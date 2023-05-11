package com.example.modeloGeneral.GestionDatos.imp;

import com.example.modeloGeneral.GestionDatos.intf.IIngredientePlatoService;
import com.example.entidades.IngredientePlato;
import com.example.entidades.Plato;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class IngredientePlatoService implements IIngredientePlatoService {

    @PersistenceContext(name = "myPersistenceUnit")
    private EntityManager entityManager;

    @Override
    public void agregarIngredientePlato(IngredientePlato ingredientePlato) {
        entityManager.persist(ingredientePlato);
    }

    @Override
    public void actualizarIngredientePlato(IngredientePlato ingredientePlato) {
        entityManager.merge(ingredientePlato);
    }

    @Override
    public void eliminarIngredientePlato(Long id) {
        IngredientePlato ingredientePlato = obtenerIngredientePlato(id);
        if (ingredientePlato != null) {
            entityManager.remove(ingredientePlato);
        }
    }

    @Override
    public IngredientePlato obtenerIngredientePlato(Long id) {
        return entityManager.find(IngredientePlato.class, id);
    }

    @Override
    public List<IngredientePlato> obtenerIngredientesPlato(Plato plato) {
        return entityManager.createQuery("SELECT i FROM IngredientePlato i WHERE i.plato = :plato", IngredientePlato.class)
                .setParameter("plato", plato)
                .getResultList();
    }
}
