package com.example.modeloGeneral.GestionDatos.imp;

import com.example.entidades.EnvioInventario;
import com.example.entidades.Restaurante;
import com.example.modeloGeneral.GestionDatos.intf.IEnvioInventarioService;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.Date;
import java.util.List;

@Stateless
public class EnvioInventarioService implements IEnvioInventarioService {

    @PersistenceContext(name = "myPersistenceUnit")
    private EntityManager entityManager;

    @Override
    public EnvioInventario agregarEnvioInventario(EnvioInventario envioInventario) {
        entityManager.persist(envioInventario);
        return envioInventario;
    }

    @Override
    public void actualizarEnvioInventario(EnvioInventario envioInventario) {
        entityManager.persist(envioInventario);
    }

    @Override
    public void eliminarEnvioInventario(Long id) {
        EnvioInventario envioInventario = obtenerEnvioInventario(id);
        if (envioInventario != null) {
            entityManager.remove(envioInventario);
        }
    }

    @Override
    public EnvioInventario obtenerEnvioInventario(Long id) {
        return entityManager.find(EnvioInventario.class, id);
    }

    @Override
    public List<EnvioInventario> obtenerTodosEnvioInventarioPorRestaurante(Restaurante restaurante) {
        return entityManager.createQuery("SELECT e FROM EnvioInventario e WHERE e.restaurante = :restaurante", EnvioInventario.class)
                .setParameter("restaurante", restaurante)
                .getResultList();
    }
}
