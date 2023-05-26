package com.example.modeloRestaurante.GestionDatos.Implementacion;

import com.example.entidades.EstadoPedido;
import com.example.modeloRestaurante.GestionDatos.Interfaces.IEstadoPedidoService;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
@Stateless
public class EstadoPedidoService implements IEstadoPedidoService {
    @PersistenceContext(name = "myPersistenceUnit")
    private EntityManager entityManager;
    @Override
    public void agregarEstadoPedido(EstadoPedido estadoPedido) {
        entityManager.persist(estadoPedido);
    }

    @Override
    public void actualizarEstadoPedido(EstadoPedido estadoPedido) {
        entityManager.merge(estadoPedido);
    }

    @Override
    public void eliminarEstadoPedido(Long id) {
        EstadoPedido estadoPedido = obtenerEstadoPedido(id);
        if (estadoPedido != null) {
            entityManager.remove(estadoPedido);
        }
    }

    @Override
    public EstadoPedido obtenerEstadoPedido(Long id) {
        return entityManager.find(EstadoPedido.class, id);
    }

    @Override
    public List<EstadoPedido> obtenerTodosEstadosPedido() {
        return entityManager.createQuery("SELECT e FROM EstadoPedido e", EstadoPedido.class).getResultList();
    }
}
