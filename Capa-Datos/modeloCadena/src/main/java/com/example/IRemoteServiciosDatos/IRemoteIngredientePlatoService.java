package com.example.IRemoteServiciosDatos;

import com.example.entidades.IngredientePlato;
import com.example.entidades.Plato;
import jakarta.ejb.Remote;

import java.util.List;

@Remote
public interface IRemoteIngredientePlatoService {
    void agregarIngredientePlato(IngredientePlato ingredientePlato);
    void actualizarIngredientePlato(IngredientePlato ingredientePlato);
    void eliminarIngredientePlato(Long id);
    IngredientePlato obtenerIngredientePlato(Long id);
    List<IngredientePlato> obtenerIngredientesPlato(Long Platoid);
}
