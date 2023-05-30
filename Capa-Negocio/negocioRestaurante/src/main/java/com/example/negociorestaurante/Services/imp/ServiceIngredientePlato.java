package com.example.negociorestaurante.Services.imp;

import com.example.entidades.IngredientePlato;
import com.example.negociorestaurante.ServiceLocator.IServiceLocator;
import com.example.negociorestaurante.Services.intf.IServiceIngredientePlato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import java.io.IOException;
import java.util.List;

@Service
public class ServiceIngredientePlato implements IServiceIngredientePlato {
    @Autowired
    @Qualifier("serviceLocator")
    private IServiceLocator serviceLocator;
    @Override
    public void agregarIngredientePlato(IngredientePlato ingredientePlato) {

    }

    @Override
    public void actualizarIngredientePlato(IngredientePlato ingredientePlato) {

    }

    @Override
    public void eliminarIngredientePlato(Long id) {

    }

    @Override
    public IngredientePlato obtenerIngredientePlato(Long id) {
        return null;
    }

    @Override
    public List<IngredientePlato> obtenerIngredientesPlato(Long Platoid) throws NamingException, IOException {
        return serviceLocator.getRemoteIngredientePlatoService().obtenerIngredientesPlato(Platoid);
    }
}
