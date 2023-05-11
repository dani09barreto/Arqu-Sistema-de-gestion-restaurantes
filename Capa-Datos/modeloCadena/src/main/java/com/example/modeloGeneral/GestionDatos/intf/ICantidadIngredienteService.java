package com.example.modeloGeneral.GestionDatos.intf;

import com.example.entidades.CantidadIngrediente;
import com.example.entidades.Plato;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface ICantidadIngredienteService {
    void agregarCantidadIngrediente(CantidadIngrediente cantidadIngrediente);
    void actualizarCantidadIngrediente(CantidadIngrediente cantidadIngrediente);
    void eliminarCantidadIngrediente(Long id);
    CantidadIngrediente obtenerCantidadIngrediente(Long id);
    List <CantidadIngrediente> obtenerTodasCantidadIngredientesPorPlato(Plato plato);
}
