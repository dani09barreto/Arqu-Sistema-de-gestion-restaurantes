package com.example.modeloRestaurante.GestionDatos.Implementacion;

import com.example.modeloRestaurante.entidades.Ingrediente;
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
    public void agregarIngrediente(Ingrediente ingrediente) {
        entityManager.persist(ingrediente);
    }

    @Override
    public void actualizarIngrediente(Ingrediente ingrediente) {
        entityManager.merge(ingrediente);
    }

    @Override
    public void eliminarIngrediente(Long id) {
        Ingrediente ingrediente = obtenerIngrediente(id);
        if (ingrediente != null) {
            entityManager.remove(ingrediente);
        }
    }

    @Override
    public Ingrediente obtenerIngrediente(Long id) {
        return entityManager.find(Ingrediente.class, id);
    }

    @Override
    public List<Ingrediente> obtenerTodosIngredientes() {
        return entityManager.createQuery("SELECT i FROM Ingrediente i", Ingrediente.class).getResultList();
    }
}
