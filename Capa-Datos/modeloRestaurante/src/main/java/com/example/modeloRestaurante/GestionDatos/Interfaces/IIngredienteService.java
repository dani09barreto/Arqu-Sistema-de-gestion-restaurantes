package com.example.modeloRestaurante.GestionDatos.Interfaces;

import com.example.entidades.IngredienteR;
import jakarta.ejb.Local;

import java.util.List;
@Local
public interface IIngredienteService {
    void agregarIngrediente(IngredienteR ingrediente);
    void actualizarIngrediente(IngredienteR ingrediente);
    void eliminarIngrediente(Long id);
    IngredienteR obtenerIngrediente(Long id);
    List<IngredienteR> obtenerTodosIngredientes();
}
