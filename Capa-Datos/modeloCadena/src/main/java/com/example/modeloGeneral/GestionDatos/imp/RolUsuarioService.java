package com.example.modeloGeneral.GestionDatos.imp;

import com.example.entidades.Rol;
import com.example.entidades.RolUsuario;
import com.example.entidades.Usuario;
import com.example.modeloGeneral.GestionDatos.intf.IRolUsuarioService;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class RolUsuarioService implements IRolUsuarioService {

    @PersistenceContext(name = "myPersistenceUnit")
    private EntityManager entityManager;

    @Override
    public void agregarRolUsuario(RolUsuario rolUsuario) {
        entityManager.persist(rolUsuario);
    }

    @Override
    public void eliminarRolUsuario(RolUsuario rolUsuario) {
        entityManager.remove(rolUsuario);
    }

    @Override
    public List<RolUsuario> obtenerRolesUsuario(Usuario usuario) {
        return entityManager.createQuery("SELECT ru FROM RolUsuario ru WHERE ru.usuario = :usuario", RolUsuario.class)
                .setParameter("usuario", usuario)
                .getResultList();
    }
}
