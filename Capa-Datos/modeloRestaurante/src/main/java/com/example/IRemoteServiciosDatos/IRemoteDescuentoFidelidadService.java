package com.example.IRemoteServiciosDatos;

import com.example.entidades.DescuentoFidelidad;

import java.util.List;

public interface IRemoteDescuentoFidelidadService {
    void agregarDescuentoFidelidad(DescuentoFidelidad descuentoFidelidad);
    void actualizarDescuentoFidelidad(DescuentoFidelidad descuentoFidelidad);
    void eliminarDescuentoFidelidad(Long id);
    DescuentoFidelidad obtenerDescuentoFidelidad(Long id);
    List<DescuentoFidelidad> obtenerTodosDescuentosFidelidad();
}
