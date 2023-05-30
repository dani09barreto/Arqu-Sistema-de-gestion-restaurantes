package com.example.modeloRestaurante.GestionDatos.Interfaces;

import com.example.modeloRestaurante.entidades.TipoPago;
import jakarta.ejb.Local;

import java.util.List;
@Local
public interface ITipoPagoService {
    void agregarTipoPago(TipoPago tipoPago);
    void actualizarTipoPago(TipoPago tipoPago);
    void eliminarTipoPago(Long id);
    TipoPago obtenerTipoPago(Long id);
    List<TipoPago> obtenerTodosTipoPagos();
    TipoPago obtenerTipoPagoPorNombre(String nombre);
}
