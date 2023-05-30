package com.example.modeloRestaurante.GestionDatos.Implementacion;

import com.example.modeloRestaurante.entidades.Mesa;
import com.example.modeloRestaurante.GestionDatos.Interfaces.IMesaService;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
@Stateless
public class MesaService implements IMesaService {
    @PersistenceContext(name = "myPersistenceUnit")
    private EntityManager entityManager;

    @Override
    public void agregarMesa(Mesa mesa) {
        entityManager.persist(mesa);
    }

    @Override
    public void actualizarMesa(Mesa mesa) {
        entityManager.merge(mesa);
    }

    @Override
    public void eliminarMesa(Long id) {
        Mesa mesa = obtenerMesa(id);
        if (mesa != null) {
            entityManager.remove(mesa);
        }
    }

    @Override
    public Mesa obtenerMesa(Long id) {
        return entityManager.find(Mesa.class, id);
    }

    @Override
    public List<Mesa> obtenerTodasMesas() {
        return entityManager.createQuery("SELECT m FROM Mesa m", Mesa.class).getResultList();
    }

}
