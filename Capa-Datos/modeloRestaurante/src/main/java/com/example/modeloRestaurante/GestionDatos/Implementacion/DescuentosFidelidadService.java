package com.example.modeloRestaurante.GestionDatos.Implementacion;

import com.example.modeloRestaurante.entidades.DescuentoFidelidad;
import com.example.modeloRestaurante.GestionDatos.Interfaces.IDescuentoFidelidadService;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
@Stateless
public class DescuentosFidelidadService implements IDescuentoFidelidadService {
    @PersistenceContext(name = "myPersistenceUnit")
    private EntityManager entityManager;
    @Override
    public void agregarDescuentoFidelidad(DescuentoFidelidad descuentoFidelidad) {
        entityManager.merge(descuentoFidelidad);
    }

    @Override
    public void actualizarDescuentoFidelidad(DescuentoFidelidad descuentoFidelidad) {
        entityManager.merge(descuentoFidelidad);
    }

    @Override
    public void eliminarDescuentoFidelidad(Long id) {
        DescuentoFidelidad descuentoFidelidad = obtenerDescuentoFidelidad(id);
        if (descuentoFidelidad != null) {
            entityManager.remove(descuentoFidelidad);
        }
    }

    @Override
    public DescuentoFidelidad obtenerDescuentoFidelidad(Long id) {
        return entityManager.find(DescuentoFidelidad.class, id);
    }

    @Override
    public List<DescuentoFidelidad> obtenerTodosDescuentosFidelidad() {
        return entityManager.createQuery("SELECT d FROM DescuentoFidelidad d", DescuentoFidelidad.class).getResultList();

    }
}
