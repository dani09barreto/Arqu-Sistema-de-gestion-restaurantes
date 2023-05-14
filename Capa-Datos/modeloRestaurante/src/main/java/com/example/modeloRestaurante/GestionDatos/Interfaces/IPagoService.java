package com.example.modeloRestaurante.GestionDatos.Interfaces;

import com.example.entidades.Pago;

import java.util.List;

public interface IPagoService {
    void agregarPago(Pago pago);
    void actualizarPago(Pago pago);
    void eliminarPago(Long id);
    Pago obtenerPago(Long id);
    List<Pago> obtenerTodosPagos();
}
