package com.example.modeloRestaurante.GestionDatos.Interfaces;

import com.example.modeloRestaurante.entidades.Reserva;
import jakarta.ejb.Local;

import java.util.List;
@Local
public interface IReservaService {
    Reserva agregarReserva(Reserva reserva);
    void actualizarReserva(Reserva reserva);
    void eliminarReserva(Long id);
    Reserva obtenerReserva(Long id);
    List<Reserva> obtenerTodasReservas();
}
