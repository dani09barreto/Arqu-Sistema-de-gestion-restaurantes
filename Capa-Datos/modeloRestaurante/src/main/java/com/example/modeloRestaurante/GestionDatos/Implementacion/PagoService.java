package com.example.modeloRestaurante.GestionDatos.Implementacion;

import com.example.entidades.Pago;
import com.example.modeloRestaurante.GestionDatos.Interfaces.IPagoService;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
@Stateless
public class PagoService implements IPagoService {
    @PersistenceContext(name = "myPersistenceUnit")
    private EntityManager entityManager;

    @Override
    public void agregarPago(Pago pago) {
        entityManager.persist(pago);
    }

    @Override
    public void actualizarPago(Pago pago) {
        entityManager.merge(pago);
    }

    @Override
    public void eliminarPago(Long id) {
        Pago pago = obtenerPago(id);
        if (pago != null) {
            entityManager.remove(pago);
        }
    }

    @Override
    public Pago obtenerPago(Long id) {
        return entityManager.find(Pago.class, id);
    }

    @Override
    public List<Pago> obtenerTodosPagos() {
        return entityManager.createQuery("SELECT p FROM Pago p", Pago.class).getResultList();
    }

}
