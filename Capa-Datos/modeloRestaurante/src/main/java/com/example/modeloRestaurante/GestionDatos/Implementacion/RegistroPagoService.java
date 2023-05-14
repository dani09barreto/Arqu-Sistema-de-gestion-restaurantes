package com.example.modeloRestaurante.GestionDatos.Implementacion;

import com.example.entidades.RegistroPago;
import com.example.modeloRestaurante.GestionDatos.Interfaces.IRegistroPagoService;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
@Stateless
public class RegistroPagoService implements IRegistroPagoService {
    @PersistenceContext(name = "myPersistenceUnit")
    private EntityManager entityManager;

    @Override
    public void agregarRegistroPago(RegistroPago registroPago) {
        entityManager.persist(registroPago);
    }

    @Override
    public void actualizarRegistroPago(RegistroPago registroPago) {
        entityManager.merge(registroPago);
    }

    @Override
    public void eliminarRegistroPago(Long id) {
        RegistroPago registroPago = obtenerRegistroPago(id);
        if (registroPago != null) {
            entityManager.remove(registroPago);
        }
    }

    @Override
    public RegistroPago obtenerRegistroPago(Long id) {
        return entityManager.find(RegistroPago.class, id);
    }

    @Override
    public List<RegistroPago> obtenerTodosRegistroPagos() {
        return entityManager.createQuery("SELECT r FROM RegistroPago r", RegistroPago.class).getResultList();
    }


}
