package com.example.IRemoteServiciosDatos;

import com.example.entidades.RegistroPago;

import java.util.List;

public interface IRemoteRegistroPagoService {
    void agregarRegistroPago(RegistroPago registroPago);
    void actualizarRegistroPago(RegistroPago registroPago);
    void eliminarRegistroPago(Long id);
    RegistroPago obtenerRegistroPago(Long id);
    List<RegistroPago> obtenerTodosRegistroPagos();
}
