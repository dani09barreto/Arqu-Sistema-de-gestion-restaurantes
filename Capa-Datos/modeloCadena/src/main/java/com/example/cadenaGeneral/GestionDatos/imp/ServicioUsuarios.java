package com.example.cadenaGeneral.GestionDatos.imp;

import com.example.cadenaGeneral.GestionDatos.intf.IUsuarioService;
import com.example.entidades.Usuario;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class ServicioUsuarios implements IUsuarioService {

    @PersistenceContext(name = "myPersistenceUnit")
    private EntityManager entityManager;

    @Override
    public Usuario agregarUsuario(Usuario usuario) {
        entityManager.persist(usuario);
        return obtenerUsuarioPorNombreUsuario(usuario.getUsuario());
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public void eliminarUsuario(String username) {
        Usuario usuario = obtenerUsuarioPorNombreUsuario(username);
        if (usuario != null) {
            entityManager.remove(usuario);
        }
    }

    @Override
    public Usuario obtenerUsuarioPorNombreUsuario(String nombreUsuario) {
        return entityManager.find(Usuario.class, nombreUsuario);
    }
}
