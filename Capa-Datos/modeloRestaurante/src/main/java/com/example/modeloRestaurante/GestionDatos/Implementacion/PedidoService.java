package com.example.modeloRestaurante.GestionDatos.Implementacion;

import com.example.entidades.Pedido;
import com.example.modeloRestaurante.GestionDatos.Interfaces.IPedidoService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class PedidoService implements IPedidoService {
    @PersistenceContext(name = "myPersistenceUnit")
    private EntityManager entityManager;

    @Override
    public void agregarPedido(Pedido pedido) {
        entityManager.persist(pedido);
    }

    @Override
    public void actualizarPedido(Pedido pedido) {
        entityManager.merge(pedido);
    }

    @Override
    public void eliminarPedido(Long id) {
        Pedido pedido = obtenerPedido(id);
        if (pedido != null) {
            entityManager.remove(pedido);
        }
    }

    @Override
    public Pedido obtenerPedido(Long id) {
        return entityManager.find(Pedido.class, id);
    }

    @Override
    public List<Pedido> obtenerTodosPedidos() {
        return entityManager.createQuery("SELECT p FROM Pedido p", Pedido.class).getResultList();
    }

}
