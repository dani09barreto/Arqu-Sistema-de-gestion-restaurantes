package com.example.modeloRestaurante.GestionDatos.Interfaces;

import com.example.entidades.TipoIngrediente;

import java.util.List;

public interface ITipoIngredienteService {
    void agregarTipoIngrediente(TipoIngrediente tipoIngrediente);
    void actualizarTipoIngrediente(TipoIngrediente tipoIngrediente);
    void eliminarTipoIngrediente(Long id);
    TipoIngrediente obtenerTipoIngrediente(Long id);
    List<TipoIngrediente> obtenerTodosTipoIngredientes();
}
