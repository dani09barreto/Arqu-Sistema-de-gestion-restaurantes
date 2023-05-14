package com.example.modeloGeneral.GestionDatos.imp;

import com.example.modeloGeneral.GestionDatos.intf.IBodegaService;
import com.example.entidades.Bodega;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class BodegaService implements IBodegaService {
    @PersistenceContext(name = "myPersistenceUnit")
    private EntityManager entityManager;

    @Override
    public void agregarBodega(Bodega bodega) {
        entityManager.persist(bodega);
    }

    @Override
    public void actualizarBodega(Bodega bodega) {
        entityManager.merge(bodega);
    }

    @Override
    public void eliminarBodega(Long id) {
        Bodega bodega = obtenerBodega(id);
        if (bodega != null) {
            entityManager.remove(bodega);
        }
    }

    @Override
    public Bodega obtenerBodega(Long id) {
        return entityManager.find(Bodega.class, id);
    }

    @Override
    public List<Bodega> obtenerTodasBodegas() {
        return entityManager.createQuery("SELECT b FROM Bodega b", Bodega.class)
                .getResultList();
    }
}
