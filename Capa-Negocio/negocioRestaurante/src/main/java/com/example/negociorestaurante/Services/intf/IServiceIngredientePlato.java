package com.example.negociorestaurante.Services.intf;

import com.example.entidades.IngredientePlato;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import java.io.IOException;
import java.util.List;

@Service
public interface IServiceIngredientePlato {
    void agregarIngredientePlato(IngredientePlato ingredientePlato);

    void actualizarIngredientePlato(IngredientePlato ingredientePlato);

    void eliminarIngredientePlato(Long id);

    IngredientePlato obtenerIngredientePlato(Long id);

    List<IngredientePlato> obtenerIngredientesPlato(Long Platoid) throws NamingException, IOException;
}
