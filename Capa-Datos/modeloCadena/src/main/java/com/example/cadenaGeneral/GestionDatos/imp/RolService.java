package com.example.cadenaGeneral.GestionDatos.imp;

import com.example.cadenaGeneral.GestionDatos.intf.IRolService;
import com.example.entidades.Rol;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class RolService implements IRolService {

    @PersistenceContext(name = "myPersistenceUnit")
    private EntityManager entityManager;

    @Override
    public void agregarRol(Rol rol) {
        entityManager.persist(rol);
    }

    @Override
    public void actualizarRol(Rol rol) {
        entityManager.merge(rol);
    }

    @Override
    public void eliminarRol(Long id) {
        Rol rol = obtenerRol(id);
        if (rol != null) {
            entityManager.remove(rol);
        }
    }

    @Override
    public Rol obtenerRol(Long id) {
        return entityManager.find(Rol.class, id);
    }

    @Override
    public Rol obtenerRolPorNombre(String nombre) {
        return entityManager.find(Rol.class, nombre);
    }

    @Override
    public List<Rol> obtenerTodosRoles() {
        return entityManager.createQuery("SELECT r FROM Rol r", Rol.class)
                .getResultList();
    }
}
