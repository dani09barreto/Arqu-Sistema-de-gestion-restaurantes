package com.example.modeloRestaurante.GestionDatos.Interfaces;

import com.example.entidades.DescuentoFidelidad;
import jakarta.ejb.Local;

import java.util.List;
@Local
public interface IDescuentoFidelidadService {
    void agregarDescuentoFidelidad(DescuentoFidelidad descuentoFidelidad);
    void actualizarDescuentoFidelidad(DescuentoFidelidad descuentoFidelidad);
    void eliminarDescuentoFidelidad(Long id);
    DescuentoFidelidad obtenerDescuentoFidelidad(Long id);
    List<DescuentoFidelidad> obtenerTodosDescuentosFidelidad();
}
