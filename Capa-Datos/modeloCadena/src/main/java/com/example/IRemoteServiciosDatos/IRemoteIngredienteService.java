package com.example.IRemoteServiciosDatos;

import com.example.entidades.Ingrediente;
import com.example.entidades.TipoIngrediente;
import jakarta.ejb.Remote;

import java.util.List;

@Remote
public interface IRemoteIngredienteService {
    void agregarIngrediente(Ingrediente ingrediente);
    void actualizarIngrediente(Ingrediente ingrediente);
    void eliminarIngrediente(Long id);
    Ingrediente obtenerIngrediente(Long id);
    List<Ingrediente> obtenerIngredientesPorTipo(Long TipoIngredienteid);
}
