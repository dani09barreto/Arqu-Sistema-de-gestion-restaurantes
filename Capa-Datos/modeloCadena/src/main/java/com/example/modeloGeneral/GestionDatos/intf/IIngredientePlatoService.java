package com.example.modeloGeneral.GestionDatos.intf;

import com.example.entidades.IngredientePlato;
import com.example.entidades.Plato;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface IIngredientePlatoService {
    void agregarIngredientePlato(IngredientePlato ingredientePlato);
    void actualizarIngredientePlato(IngredientePlato ingredientePlato);
    void eliminarIngredientePlato(Long id);
    IngredientePlato obtenerIngredientePlato(Long id);
    List <IngredientePlato> obtenerIngredientesPlato(Plato plato);
}
