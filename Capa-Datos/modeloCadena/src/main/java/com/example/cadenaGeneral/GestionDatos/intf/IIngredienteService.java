package com.example.cadenaGeneral.GestionDatos.intf;

import com.example.entidades.Ingrediente;
import com.example.entidades.TipoIngrediente;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface IIngredienteService {
    void agregarIngrediente(Ingrediente ingrediente);
    void actualizarIngrediente(Ingrediente ingrediente);
    void eliminarIngrediente(Long id);
    Ingrediente obtenerIngrediente(Long id);
    List <Ingrediente> obtenerIngredientesPorTipo(TipoIngrediente tipoIngrediente);
}
