package com.example.negociogeneral.Services.imp;

import com.example.entidades.Ingrediente;
import com.example.entidades.TipoIngrediente;
import com.example.negociogeneral.ServiceLocator.IServiceLocator;
import com.example.negociogeneral.Services.intf.IServicioIngrediente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import java.io.IOException;
import java.util.List;

@Service
public class ServicioIngrediente implements IServicioIngrediente {

    @Autowired
    @Qualifier("serviceLocator")
    private IServiceLocator serviceLocator;

    @Override
    public void agregarIngrediente(Ingrediente ingrediente, String uri) {

    }

    @Override
    public Ingrediente obtenerIngrediente(Long id, String uri) throws NamingException, IOException {
        return serviceLocator.getRemoteIngredienteService(uri).obtenerIngrediente(id);
    }

    @Override
    public void actualizarIngrediente(Ingrediente ingrediente, String uri) {

    }

    @Override
    public void eliminarIngrediente(Long id, String uri) {

    }

    @Override
    public List<Ingrediente> obtenerIngredientesPorTipo(TipoIngrediente tipoIngrediente, String uri) {
        return null;
    }
}
