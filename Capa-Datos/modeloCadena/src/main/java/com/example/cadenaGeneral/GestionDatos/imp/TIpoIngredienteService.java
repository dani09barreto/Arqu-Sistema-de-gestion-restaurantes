package com.example.cadenaGeneral.GestionDatos.imp;

import com.example.cadenaGeneral.GestionDatos.intf.ITipoIngredienteService;
import com.example.entidades.TipoIngrediente;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class TIpoIngredienteService implements ITipoIngredienteService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void agregarTipoIngrediente(TipoIngrediente tipoIngrediente) {
        entityManager.persist(tipoIngrediente);
    }

    @Override
    public void actualizarTipoIngrediente(TipoIngrediente tipoIngrediente) {
        entityManager.merge(tipoIngrediente);
    }

    @Override
    public void eliminarTipoIngrediente(Long id) {
        TipoIngrediente tipoIngrediente = obtenerTipoIngrediente(id);
        if (tipoIngrediente != null) {
            entityManager.remove(tipoIngrediente);
        }
    }

    @Override
    public TipoIngrediente obtenerTipoIngrediente(Long id) {
        return entityManager.find(TipoIngrediente.class, id);
    }

    @Override
    public List<TipoIngrediente> obtenerTodosTipoIngrediente() {
        return entityManager.createQuery("SELECT t FROM TipoIngrediente t", TipoIngrediente.class)
                .getResultList();
    }
}
