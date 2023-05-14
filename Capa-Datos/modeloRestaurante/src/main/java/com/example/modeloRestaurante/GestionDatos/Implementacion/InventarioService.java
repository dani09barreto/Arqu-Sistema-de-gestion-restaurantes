package com.example.modeloRestaurante.GestionDatos.Implementacion;

import com.example.entidades.Inventario;
import com.example.modeloRestaurante.GestionDatos.Interfaces.IInventarioService;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
@Stateless
public class InventarioService implements IInventarioService {
    @PersistenceContext(name = "myPersistenceUnit")
    private EntityManager entityManager;

    @Override
    public void agregarInventario(Inventario inventario) {
        entityManager.persist(inventario);
    }

    @Override
    public void actualizarInventario(Inventario inventario) {
        entityManager.merge(inventario);
    }

    @Override
    public void eliminarInventario(Long id) {
        Inventario inventario = obtenerInventario(id);
        if (inventario != null) {
            entityManager.remove(inventario);
        }
    }

    @Override
    public Inventario obtenerInventario(Long id) {
        return entityManager.find(Inventario.class, id);
    }

    @Override
    public List<Inventario> obtenerTodosInventarios() {
        return entityManager.createQuery("SELECT i FROM Inventario i", Inventario.class).getResultList();
    }

}
