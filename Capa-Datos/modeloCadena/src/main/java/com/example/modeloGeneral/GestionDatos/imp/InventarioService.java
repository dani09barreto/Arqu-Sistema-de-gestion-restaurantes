package com.example.modeloGeneral.GestionDatos.imp;

import com.example.entidades.Bodega;
import com.example.entidades.Ingrediente;
import com.example.entidades.Inventario;
import com.example.modeloGeneral.GestionDatos.intf.IInventarioService;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

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
    public List<Inventario> obtenerTodosInventarioPorBodega(Bodega bodega, int page, int pageSize) {
        TypedQuery<Inventario> query = entityManager.createQuery("SELECT i FROM Inventario i WHERE i.bodega = :bodega", Inventario.class)
                .setParameter("bodega", bodega)
                .setFirstResult(page * pageSize) // Calcular el índice de inicio
                .setMaxResults(pageSize); // Establecer el tamaño de página

        return query.getResultList();
    }

    @Override
    public Inventario obtenerTodosInventarioPorBodegaPorIngrediente(Bodega bodega, Ingrediente ingrediente) {
        return entityManager.createQuery("SELECT i FROM Inventario i WHERE i.bodega = :bodega AND i.ingrediente = :ingrediente", Inventario.class)
                .setParameter("bodega", bodega)
                .setParameter("ingrediente", ingrediente)
                .getSingleResult();
    }
}
