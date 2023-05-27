package com.example.modeloRestaurante.RemoteServiciosData;

import com.example.IRemoteServiciosDatos.IRemoteIngredientePlatoService;
import com.example.entidades.IngredientePlato;
import com.example.modeloRestaurante.GestionDatos.Interfaces.IIngredientePlatoService;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;
@Stateless

public class RemoteIngredientePlato implements IRemoteIngredientePlatoService {
    @EJB
    IIngredientePlatoService iIngredientePlatoService;

    @Override
    public void agregarIngredientePlato(IngredientePlato plato) {
        iIngredientePlatoService.agregarIngredientePlato(plato);
    }

    @Override
    public void actualizarIngredientePlato(IngredientePlato plato) {
        iIngredientePlatoService.actualizarIngredientePlato(plato);
    }

    @Override
    public void eliminarIngredientePlato(Long id) {
        iIngredientePlatoService.eliminarIngredientePlato(id);
    }

    @Override
    public IngredientePlato obtenerIngredientePlato(Long id) {
        return iIngredientePlatoService.obtenerIngredientePlato(id);
    }

    @Override
    public List<IngredientePlato> obtenerTodosIngredientePlato() {
        return iIngredientePlatoService.obtenerTodosIngredientePlato();
    }
}
