package com.example.IRemoteServiciosDatos;

import com.example.entidades.Ingrediente;

import java.util.List;

public interface IRemoteIngredienteService {
    void agregarIngrediente(Ingrediente ingrediente);
    void actualizarIngrediente(Ingrediente ingrediente);
    void eliminarIngrediente(Long id);
    Ingrediente obtenerIngrediente(Long id);
    List<Ingrediente> obtenerTodosIngredientes();
}
