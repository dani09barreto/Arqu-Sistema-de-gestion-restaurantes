package com.example.modeloRestaurante.GestionDatos.Interfaces;

import com.example.modeloRestaurante.entidades.RegistroPago;
import jakarta.ejb.Local;

import java.util.List;
@Local
public interface IRegistroPagoService {
    void agregarRegistroPago(RegistroPago registroPago);
    void actualizarRegistroPago(RegistroPago registroPago);
    void eliminarRegistroPago(Long id);
    RegistroPago obtenerRegistroPago(Long id);
    List<RegistroPago> obtenerTodosRegistroPagos();
}
