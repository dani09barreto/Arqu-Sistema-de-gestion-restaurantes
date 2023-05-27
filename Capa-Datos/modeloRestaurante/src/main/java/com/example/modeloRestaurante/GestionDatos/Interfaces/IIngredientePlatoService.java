package com.example.modeloRestaurante.GestionDatos.Interfaces;

import com.example.entidades.IngredientePlato;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface IIngredientePlatoService {
    void agregarIngredientePlato(IngredientePlato plato);
    void actualizarIngredientePlato(IngredientePlato plato);
    void eliminarIngredientePlato(Long id);
    IngredientePlato obtenerIngredientePlato(Long id);
    List<IngredientePlato> obtenerTodosIngredientePlato();

}