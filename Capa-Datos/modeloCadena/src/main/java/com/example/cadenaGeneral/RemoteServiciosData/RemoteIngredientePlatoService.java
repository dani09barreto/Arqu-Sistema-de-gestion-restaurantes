package com.example.cadenaGeneral.RemoteServiciosData;

import com.example.IRemoteServiciosDatos.IRemoteIngredientePlatoService;
import com.example.cadenaGeneral.GestionDatos.intf.IIngredientePlatoService;
import com.example.cadenaGeneral.GestionDatos.intf.IPlatoService;
import com.example.entidades.IngredientePlato;
import com.example.entidades.Plato;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class RemoteIngredientePlatoService implements IRemoteIngredientePlatoService {

    @EJB
    IIngredientePlatoService ingredientePlatoService;
    @EJB
    IPlatoService platoService;

    @Override
    public void agregarIngredientePlato(IngredientePlato ingredientePlato) {
        ingredientePlatoService.agregarIngredientePlato(ingredientePlato);
    }

    @Override
    public void actualizarIngredientePlato(IngredientePlato ingredientePlato) {
        ingredientePlatoService.actualizarIngredientePlato(ingredientePlato);
    }

    @Override
    public void eliminarIngredientePlato(Long id) {
        ingredientePlatoService.eliminarIngredientePlato(id);
    }

    @Override
    public IngredientePlato obtenerIngredientePlato(Long id) {
        return ingredientePlatoService.obtenerIngredientePlato(id);
    }

    @Override
    public List<IngredientePlato> obtenerIngredientesPlato(Long Platoid) {
        Plato plato = platoService.obtenerPlato(Platoid);
        return ingredientePlatoService.obtenerIngredientesPlato(plato);
    }
}
