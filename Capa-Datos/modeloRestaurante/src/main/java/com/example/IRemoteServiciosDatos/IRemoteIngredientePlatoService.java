package com.example.IRemoteServiciosDatos;


import com.example.entidades.IngredientePlato;
import jakarta.ejb.Remote;

import java.util.List;
@Remote
public interface IRemoteIngredientePlatoService {

    void agregarIngredientePlato(IngredientePlato plato);
    void actualizarIngredientePlato(IngredientePlato plato);
    void eliminarIngredientePlato(Long id);
    IngredientePlato obtenerIngredientePlato(Long id);
    List<IngredientePlato> obtenerTodosIngredientePlato();
}
