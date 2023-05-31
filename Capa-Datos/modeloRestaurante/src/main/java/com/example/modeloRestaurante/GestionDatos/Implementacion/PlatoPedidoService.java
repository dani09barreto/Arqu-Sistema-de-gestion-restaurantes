package com.example.modeloRestaurante.GestionDatos.Implementacion;

import com.example.modeloRestaurante.entidades.PlatoPedido;
import com.example.modeloRestaurante.GestionDatos.Interfaces.IPlatoPedidoService;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
@Stateless
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

    @Override
    public List<PlatoPedido> obtenerTodosPlatoPorPedido(long id) {
        return entityManager.createQuery("SELECT P FROM PlatoPedido  p WHERE P.Pedidoid = :id",PlatoPedido.class).setParameter("id",id).getResultList();
    }

}
