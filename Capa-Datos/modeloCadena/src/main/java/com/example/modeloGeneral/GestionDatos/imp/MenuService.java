package com.example.modeloGeneral.GestionDatos.imp;

import com.example.modeloGeneral.GestionDatos.intf.IMenuService;
import com.example.entidades.Menu;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class MenuService implements IMenuService {
    @PersistenceContext(name = "myPersistenceUnit")
    private EntityManager entityManager;

    @Override
    public Menu agregarMenu(Menu menu) {
        entityManager.persist(menu);
        return obtenerMenuPorNombre(menu.getNombre());
    }

    @Override
    public void actualizarMenu(Menu menu) {
        entityManager.merge(menu);
    }

    @Override
    public void eliminarMenu(Long id) {
        Menu menu = obtenerMenu(id);
        if (menu != null) {
            entityManager.remove(menu);
        }
    }

    @Override
    public Menu obtenerMenu(Long id) {
        return entityManager.find(Menu.class, id);
    }

    @Override
    public Menu obtenerMenuPorNombre(String nombre) {
        return entityManager.createQuery("SELECT m FROM Menu m WHERE m.nombre = :nombre", Menu.class)
                .setParameter("nombre", nombre)
                .getSingleResult();
    }

    @Override
    public List<Menu> obtenerTodosMenus() {
        return entityManager.createQuery("SELECT m FROM Menu m", Menu.class)
                .getResultList();
    }
}
