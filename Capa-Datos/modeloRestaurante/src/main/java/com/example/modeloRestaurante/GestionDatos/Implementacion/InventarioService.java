package com.example.modeloRestaurante.GestionDatos.Implementacion;

import com.example.entidades.InventarioR;
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
    public void agregarInventario(InventarioR inventario) {
        entityManager.persist(inventario);
    }

    @Override
    public void actualizarInventario(InventarioR inventario) {
        entityManager.merge(inventario);
    }

    @Override
    public void eliminarInventario(Long id) {
        InventarioR inventario = obtenerInventario(id);
        if (inventario != null) {
            entityManager.remove(inventario);
        }
    }

    @Override
    public InventarioR obtenerInventario(Long id) {
        return entityManager.find(InventarioR.class, id);
    }

    @Override
    public List<InventarioR> obtenerTodosInventarios() {
        return entityManager.createQuery("SELECT i FROM InventarioR i", InventarioR.class).getResultList();
    }

    @Override
    public InventarioR obtenerInvetarioporIngrediente(Long id) {
        return entityManager.createQuery("SELECT i FROM InventarioR i WHERE i.Ingredienteid = :id", InventarioR.class).setParameter("id", id).getSingleResult();
    }

}
