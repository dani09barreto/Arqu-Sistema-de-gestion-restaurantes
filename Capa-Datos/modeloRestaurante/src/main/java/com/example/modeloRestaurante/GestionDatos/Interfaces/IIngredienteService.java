package com.example.modeloRestaurante.GestionDatos.Interfaces;

import com.example.entidades.Ingrediente;

import java.util.List;

public interface IIngredienteService {
    void agregarIngrediente(Ingrediente ingrediente);
    void actualizarIngrediente(Ingrediente ingrediente);
    void eliminarIngrediente(Long id);
    Ingrediente obtenerIngrediente(Long id);
    List<Ingrediente> obtenerTodosIngredientes();
}
