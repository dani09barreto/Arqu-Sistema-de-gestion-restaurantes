package com.example.modeloGeneral.GestionDatos.imp;

import com.example.modeloGeneral.GestionDatos.intf.IEstadoEnvioService;
import com.example.entidades.EstadoEnvio;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class EstadoEnvioService implements IEstadoEnvioService {
    @PersistenceContext(name = "myPersistenceUnit")
    private EntityManager entityManager;
    @Override
    public void agregarEstadoEnvio(EstadoEnvio estadoEnvio) {
        entityManager.persist(estadoEnvio);
    }

    @Override
    public void actualizarEstadoEnvio(EstadoEnvio estadoEnvio) {
        entityManager.merge(estadoEnvio);
    }

    @Override
    public void eliminarEstadoEnvio(Long id) {
        EstadoEnvio estadoEnvio = obtenerEstadoEnvio(id);
        if (estadoEnvio != null) {
            entityManager.remove(estadoEnvio);
        }
    }

    @Override
    public EstadoEnvio obtenerEstadoEnvio(Long id) {
        return entityManager.find(EstadoEnvio.class, id);
    }

    @Override
    public EstadoEnvio obtenerEstadoEnvioPorNombre(String nombre) {
        return entityManager.createQuery("SELECT e FROM EstadoEnvio e WHERE e.estado = :nombre", EstadoEnvio.class)
                .setParameter("nombre", nombre)
                .getSingleResult();
    }

    @Override
    public List<EstadoEnvio> obtenerTodosEstadosEnvio() {
        return entityManager.createQuery("SELECT e FROM EstadoEnvio e", EstadoEnvio.class)
                .getResultList();
    }

}
