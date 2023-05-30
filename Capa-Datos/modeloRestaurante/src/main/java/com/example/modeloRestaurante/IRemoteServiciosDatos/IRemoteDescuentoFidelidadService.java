package com.example.modeloRestaurante.IRemoteServiciosDatos;

import com.example.modeloRestaurante.entidades.DescuentoFidelidad;
import jakarta.ejb.Remote;

import java.util.List;
@Remote
public interface IRemoteDescuentoFidelidadService {
    void agregarDescuentoFidelidad(DescuentoFidelidad descuentoFidelidad);
    void actualizarDescuentoFidelidad(DescuentoFidelidad descuentoFidelidad);
    void eliminarDescuentoFidelidad(Long id);
    DescuentoFidelidad obtenerDescuentoFidelidad(Long id);
    List<DescuentoFidelidad> obtenerTodosDescuentosFidelidad();
}
