package com.example.cadenaGeneral.GestionDatos.imp;

import com.example.cadenaGeneral.GestionDatos.intf.IIngredienteService;
import com.example.entidades.Ingrediente;
import com.example.entidades.TipoIngrediente;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class IngredienteService implements IIngredienteService {

    @PersistenceContext
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
    public List<Ingrediente> obtenerIngredientesPorTipo(TipoIngrediente tipoIngrediente) {
        return entityManager.createQuery("SELECT i FROM Ingrediente i WHERE i.tipoIngrediente = :tipoIngrediente", Ingrediente.class)
                .setParameter("tipoIngrediente", tipoIngrediente)
                .getResultList();
    }
}
