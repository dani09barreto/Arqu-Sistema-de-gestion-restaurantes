package com.example.modeloRestaurante.IRemoteServiciosDatos;

import com.example.modeloRestaurante.entidades.Ingrediente;
import jakarta.ejb.Remote;

import java.util.List;
@Remote
public interface IRemoteIngredienteService {
    void agregarIngrediente(Ingrediente ingrediente);
    void actualizarIngrediente(Ingrediente ingrediente);
    void eliminarIngrediente(Long id);
    Ingrediente obtenerIngrediente(Long id);
    List<Ingrediente> obtenerTodosIngredientes();
}
