package com.example.modeloRestaurante.GestionDatos.Implementacion;

import com.example.entidades.Adicionales;
import com.example.modeloRestaurante.GestionDatos.Interfaces.IAdicionalesService;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
@Stateless
public class AdicionalesService implements IAdicionalesService {
    @PersistenceContext(name = "myPersistenceUnit")
    private EntityManager entityManager;

    @Override
    public void agregarAdicionales(Adicionales adicionales) {
        entityManager.persist(adicionales);
    }

    @Override
    public void actualizarAdicionales(Adicionales adicionales) {
        entityManager.merge(adicionales);
    }

    @Override
    public void eliminarAdicionales(Long id) {
        Adicionales adicionales = obtenerAdicionales(id);
        if (adicionales != null) {
            entityManager.remove(adicionales);
        }
    }

    @Override
    public Adicionales obtenerAdicionales(Long id) {
        return entityManager.find(Adicionales.class,id);
    }

    @Override
    public List<Adicionales> obtenerTodasAdicionales() {
        return entityManager.createQuery("SELECT a FROM Adicionales a",Adicionales.class).getResultList();
    }
}
