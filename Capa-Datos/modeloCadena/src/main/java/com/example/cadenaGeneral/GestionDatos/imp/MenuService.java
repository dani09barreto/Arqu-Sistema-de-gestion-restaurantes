package com.example.cadenaGeneral.GestionDatos.imp;

import com.example.cadenaGeneral.GestionDatos.intf.IMenuService;
import com.example.entidades.Menu;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class MenuService implements IMenuService {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void agregarMenu(Menu menu) {
        entityManager.persist(menu);
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
    public List<Menu> obtenerTodosMenus() {
        return entityManager.createQuery("SELECT m FROM Menu m", Menu.class)
                .getResultList();
    }
}
