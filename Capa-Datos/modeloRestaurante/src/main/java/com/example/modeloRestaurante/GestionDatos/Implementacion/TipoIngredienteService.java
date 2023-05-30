package com.example.modeloRestaurante.GestionDatos.Implementacion;

import com.example.modeloRestaurante.entidades.TipoIngrediente;
import com.example.modeloRestaurante.GestionDatos.Interfaces.ITipoIngredienteService;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
@Stateless
public class TipoIngredienteService implements ITipoIngredienteService {
    @PersistenceContext(name = "myPersistenceUnit")
    private EntityManager entityManager;

    public void agregarTipoIngrediente(TipoIngrediente tipoIngrediente) {
        entityManager.persist(tipoIngrediente);
    }

    public void actualizarTipoIngrediente(TipoIngrediente tipoIngrediente) {
        entityManager.merge(tipoIngrediente);
    }

    public void eliminarTipoIngrediente(Long id) {
        TipoIngrediente tipoIngrediente = obtenerTipoIngrediente(id);
        if (tipoIngrediente != null) {
            entityManager.remove(tipoIngrediente);
        }
    }

    public TipoIngrediente obtenerTipoIngrediente(Long id) {
        return entityManager.find(TipoIngrediente.class, id);
    }

    @Override
    public List<TipoIngrediente> obtenerTodosTipoIngredientes() {
        return entityManager.createQuery("SELECT t FROM TipoIngrediente t", TipoIngrediente.class).getResultList();
    }


}
