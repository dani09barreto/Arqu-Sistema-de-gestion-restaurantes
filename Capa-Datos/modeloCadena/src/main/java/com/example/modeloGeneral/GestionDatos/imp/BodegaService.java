package com.example.modeloGeneral.GestionDatos.imp;

import com.example.modeloGeneral.GestionDatos.intf.IBodegaService;
import com.example.entidades.Bodega;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Stateless
public class BodegaService implements IBodegaService {
    @PersistenceContext(name = "myPersistenceUnit")
    private EntityManager entityManager;

    private ConcurrentMap<Long, Bodega> cache = new ConcurrentHashMap<>();

    @Override
    public void agregarBodega(Bodega bodega) {
        entityManager.persist(bodega);
        cache.put(bodega.getId(), bodega);
    }

    @Override
    public void actualizarBodega(Bodega bodega) {
        entityManager.merge(bodega);
        cache.put(bodega.getId(), bodega);
    }

    @Override
    public void eliminarBodega(Long id) {
        Bodega bodega = obtenerBodega(id);
        if (bodega != null) {
            entityManager.remove(bodega);
            cache.remove(id);
        }
    }

    @Override
    public Bodega obtenerBodega(Long id) {
        Bodega bodega = cache.get(id);
        if (bodega == null) {
            bodega = entityManager.find(Bodega.class, id);
            if (bodega != null) {
                cache.put(id, bodega);
            }
        }
        return bodega;
    }

    @Override
    public List<Bodega> obtenerTodasBodegas() {
        return entityManager.createQuery("SELECT b FROM Bodega b", Bodega.class)
                .getResultList();
    }
}
