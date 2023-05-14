package com.example.modeloRestaurante.GestionDatos.Interfaces;

import com.example.entidades.RegistroPago;

import java.util.List;

public interface IRegistroPagoService {
    void agregarRegistroPago(RegistroPago registroPago);
    void actualizarRegistroPago(RegistroPago registroPago);
    void eliminarRegistroPago(Long id);
    RegistroPago obtenerRegistroPago(Long id);
    List<RegistroPago> obtenerTodosRegistroPagos();
}
