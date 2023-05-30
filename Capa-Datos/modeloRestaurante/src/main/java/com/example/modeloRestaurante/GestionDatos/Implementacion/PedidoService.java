package com.example.modeloRestaurante.GestionDatos.Implementacion;

import com.example.modeloRestaurante.entidades.Pedido;
import com.example.modeloRestaurante.GestionDatos.Interfaces.IPedidoService;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
@Stateless
public class PedidoService implements IPedidoService {
    @PersistenceContext(name = "myPersistenceUnit")
    private EntityManager entityManager;

    @Override
    public Pedido agregarPedido(Pedido pedido) {
        entityManager.persist(pedido);
        return pedido;
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
