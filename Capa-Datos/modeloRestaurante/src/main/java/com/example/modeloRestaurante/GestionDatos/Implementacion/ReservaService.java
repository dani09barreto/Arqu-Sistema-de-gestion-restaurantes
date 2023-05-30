package com.example.modeloRestaurante.GestionDatos.Implementacion;

import com.example.modeloRestaurante.GestionDatos.Interfaces.IReservaService;
import com.example.modeloRestaurante.entidades.Reserva;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
@Stateless
public class ReservaService implements IReservaService{
    @PersistenceContext(name = "myPersistenceUnit")
    private EntityManager entityManager;
    @Override
    public Reserva agregarReserva(Reserva reserva) {
         entityManager.persist(reserva);
         return reserva;
    }

    @Override
    public void actualizarReserva(Reserva reserva) {
        entityManager.merge(reserva);
    }

    @Override
    public void eliminarReserva(Long id) {
        Reserva reserva = obtenerReserva(id);
        if (reserva != null) {
            entityManager.remove(reserva);
        }
    }

    @Override
    public Reserva obtenerReserva(Long id) {
        return entityManager.find(Reserva.class, id);
    }

    @Override
    public List<Reserva> obtenerTodasReservas() {
        return entityManager.createQuery("SELECT r FROM Reserva r", Reserva.class).getResultList();
    }
}
