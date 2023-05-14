package com.example.modeloRestaurante.GestionDatos.Implementacion;

import com.example.entidades.TipoPago;
import com.example.modeloRestaurante.GestionDatos.Interfaces.ITipoPagoService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class TipoPagoService implements ITipoPagoService {
    @PersistenceContext(name = "myPersistenceUnit")
    private EntityManager entityManager;

    @Override
    public void agregarTipoPago(TipoPago tipoPago) {
        entityManager.persist(tipoPago);
    }

    @Override
    public void actualizarTipoPago(TipoPago tipoPago) {
        entityManager.merge(tipoPago);
    }

    @Override
    public void eliminarTipoPago(Long id) {
        TipoPago tipoPago = obtenerTipoPago(id);
        if (tipoPago != null) {
            entityManager.remove(tipoPago);
        }
    }

    @Override
    public TipoPago obtenerTipoPago(Long id) {
        return entityManager.find(TipoPago.class, id);
    }

    @Override
    public List<TipoPago> obtenerTodosTipoPagos() {
        return entityManager.createQuery("SELECT t FROM TipoPago t", TipoPago.class).getResultList();
    }

}
