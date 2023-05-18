package com.example.negociogeneral.Services.imp;

import com.example.entidades.Menu;
import com.example.entidades.Plato;
import com.example.negociogeneral.ServiceLocator.IServiceLocator;
import com.example.negociogeneral.Services.intf.IServicioPlato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import java.io.IOException;
import java.util.List;

@Service
public class ServicioPlato implements IServicioPlato {

    @Autowired
    @Qualifier("serviceLocator")
    private IServiceLocator serviceLocator;

    @Override
    public void agregarPlato(Plato plato) {

    }

    @Override
    public void actualizarPlato(Plato plato) {

    }

    @Override
    public void eliminarPlato(Long id) {

    }

    @Override
    public Plato obtenerPlato(Long id) {
        return null;
    }

    @Override
    public List<Plato> obtenerTodosPlatosPorMenu(Menu menu) throws NamingException, IOException {
        return serviceLocator.getRemotePlatoService().obtenerTodosPlatosPorMenu(menu.getId());
    }
}
