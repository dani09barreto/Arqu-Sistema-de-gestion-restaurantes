package com.example.modeloRestaurante.IRemoteServiciosDatos;

import com.example.modeloRestaurante.entidades.Reserva;
import com.example.modeloRestaurante.entidades.TipoIngrediente;
import jakarta.ejb.Remote;

import java.util.List;

@Remote
public interface IRemoteReservaService {
    Reserva agregarReserva(Reserva reserva);
    void actualizarReserva(Reserva reserva);
    void eliminarReserva(Long id);
    Reserva obtenerReserva(Long id);
    List<Reserva> obtenerTodasReservas();
}
