package com.example.negociogeneral.Services.imp;

import com.example.entidades.Menu;
import com.example.negociogeneral.ServiceLocator.IServiceLocator;
import com.example.negociogeneral.Services.intf.IServicioMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import java.io.IOException;
import java.util.List;

@Service
public class ServicioMenu implements IServicioMenu {
    @Autowired
    @Qualifier("serviceLocator")
    private IServiceLocator serviceLocator;

    @Override
    public Menu agregarMenu(Menu menu) throws NamingException, IOException {
        return serviceLocator.getRemoteMenuService().agregarMenu(menu);
    }

    @Override
    public void actualizarMenu(Menu menu) throws NamingException, IOException {
        serviceLocator.getRemoteMenuService().actualizarMenu(menu);
    }

    @Override
    public void eliminarMenu(Long id) throws NamingException, IOException {
        serviceLocator.getRemoteMenuService().eliminarMenu(id);
    }

    @Override
    public Menu obtenerMenu(Long id) throws NamingException, IOException {
        return serviceLocator.getRemoteMenuService().obtenerMenu(id);
    }

    @Override
    public List<Menu> obtenerTodosMenus() throws NamingException, IOException {
        return serviceLocator.getRemoteMenuService().obtenerTodosMenus();
    }
}
