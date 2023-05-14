package com.example.modeloRestaurante.GestionDatos.Implementacion;

import com.example.entidades.PlatoPedido;
import com.example.modeloRestaurante.GestionDatos.Interfaces.IPlatoPedidoService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class PlatoPedidoService implements IPlatoPedidoService {
    @PersistenceContext(name = "myPersistenceUnit")
    private EntityManager entityManager;

    @Override
    public void agregarPlatoPedido(PlatoPedido platoPedido) {
        entityManager.persist(platoPedido);
    }

    @Override
    public void actualizarPlatoPedido(PlatoPedido platoPedido) {
        entityManager.merge(platoPedido);
    }

    @Override
    public void eliminarPlatoPedido(Long id) {
        PlatoPedido platoPedido = obtenerPlatoPedido(id);
        if (platoPedido != null) {
            entityManager.remove(platoPedido);
        }
    }

    @Override
    public PlatoPedido obtenerPlatoPedido(Long id) {
        return entityManager.find(PlatoPedido.class, id);
    }

    @Override
    public List<PlatoPedido> obtenerTodosPlatoPedidos() {
        return entityManager.createQuery("SELECT p FROM PlatoPedido p", PlatoPedido.class).getResultList();
    }

}
