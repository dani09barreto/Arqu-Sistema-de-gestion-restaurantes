package com.example.modeloRestaurante.GestionDatos.Interfaces;

import com.example.entidades.TipoPago;

import java.util.List;

public interface ITipoPagoService {
    void agregarTipoPago(TipoPago tipoPago);
    void actualizarTipoPago(TipoPago tipoPago);
    void eliminarTipoPago(Long id);
    TipoPago obtenerTipoPago(Long id);
    List<TipoPago> obtenerTodosTipoPagos();
}
