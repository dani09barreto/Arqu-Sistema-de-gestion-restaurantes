package com.example.negociogeneral.Services.imp;

import com.example.entidades.IngredientePlato;
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
    public Plato agregarPlato(Plato plato, String uri) throws NamingException, IOException {
        return serviceLocator.getRemotePlatoService(uri).agregarPlato(plato);
    }

    @Override
    public void actualizarPlato(Plato plato, String uri) {

    }

    @Override
    public void eliminarPlato(Long id, String uri) {

    }

    @Override
    public Plato obtenerPlato(Long id, String uri) throws NamingException, IOException {
        return serviceLocator.getRemotePlatoService(uri).obtenerPlato(id);
    }

    @Override
    public List<Plato> obtenerTodosPlatosPorMenu(Menu menu, String uri) throws NamingException, IOException {
        return serviceLocator.getRemotePlatoService(uri).obtenerTodosPlatosPorMenu(menu.getId());
    }

    @Override
    public void agregarIngredienteAPlato(IngredientePlato ingredientePlato, String uri) throws NamingException, IOException {
        serviceLocator.getRemoteIngredientePlatoService(uri).agregarIngredientePlato(ingredientePlato);
    }

    @Override
    public List<IngredientePlato> obtenerIngredientesPorPlato(Long idPlato, String uri) throws NamingException, IOException {
        return serviceLocator.getRemoteIngredientePlatoService(uri).obtenerIngredientesPlato(idPlato);
    }
}
