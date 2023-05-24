package com.example.modeloGeneral.GestionDatos.imp;

import com.example.modeloGeneral.GestionDatos.intf.ICantidadIngredienteService;
import com.example.entidades.CantidadIngrediente;
import com.example.entidades.Plato;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class CantidadIngredienteService implements ICantidadIngredienteService {

    @PersistenceContext(name = "myPersistenceUnit")
    private EntityManager entityManager;

    @Override
    public void agregarCantidadIngrediente(CantidadIngrediente cantidadIngrediente) {
        entityManager.persist(cantidadIngrediente);
    }

    @Override
    public void actualizarCantidadIngrediente(CantidadIngrediente cantidadIngrediente) {
        entityManager.merge(cantidadIngrediente);
    }

    @Override
    public void eliminarCantidadIngrediente(Long id) {
        CantidadIngrediente cantidadIngrediente = obtenerCantidadIngrediente(id);
        if (cantidadIngrediente != null) {
            entityManager.remove(cantidadIngrediente);
        }
    }

    @Override
    public CantidadIngrediente obtenerCantidadIngrediente(Long id) {
        return entityManager.find(CantidadIngrediente.class, id);
    }
}
