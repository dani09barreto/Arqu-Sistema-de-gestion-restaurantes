package com.example.modeloGeneral.GestionDatos.imp;

import com.example.modeloGeneral.GestionDatos.intf.IUsuarioService;
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
        try{
            entityManager.persist(usuario);
            return obtenerUsuarioPorNombreUsuario(usuario.getUsuario());
        }catch (Exception e) {
            System.out.println("Error al agregar usuario: " + e.getMessage());
            return null;
        }
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
        try{
            return entityManager.createQuery("SELECT u FROM Usuario u WHERE u.usuario = :usuario", Usuario.class)
                    .setParameter("usuario", nombreUsuario)
                    .getSingleResult();
        }catch (Exception e){
            return null;
        }
    }
}
