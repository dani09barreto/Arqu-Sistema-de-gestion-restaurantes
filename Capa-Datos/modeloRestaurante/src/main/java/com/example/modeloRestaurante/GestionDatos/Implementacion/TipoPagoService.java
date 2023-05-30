package com.example.modeloRestaurante.GestionDatos.Implementacion;

import com.example.modeloRestaurante.entidades.TipoPago;
import com.example.modeloRestaurante.GestionDatos.Interfaces.ITipoPagoService;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
@Stateless
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

    @Override
    public TipoPago obtenerTipoPagoPorNombre(String nombre) {
        return entityManager.createQuery("SELECT t FROM TipoPago t WHERE t.nombre = :nombre", TipoPago.class)
                .setParameter("nombre", nombre)
                .getSingleResult();
    }

}
