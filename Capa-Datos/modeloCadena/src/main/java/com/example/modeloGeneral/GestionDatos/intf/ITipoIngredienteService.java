package com.example.modeloGeneral.GestionDatos.intf;

import com.example.entidades.TipoIngrediente;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface ITipoIngredienteService {
    void agregarTipoIngrediente(TipoIngrediente tipoIngrediente);
    void actualizarTipoIngrediente(TipoIngrediente tipoIngrediente);
    void eliminarTipoIngrediente(Long id);
    TipoIngrediente obtenerTipoIngrediente(Long id);
    List<TipoIngrediente> obtenerTodosTipoIngrediente();
}
