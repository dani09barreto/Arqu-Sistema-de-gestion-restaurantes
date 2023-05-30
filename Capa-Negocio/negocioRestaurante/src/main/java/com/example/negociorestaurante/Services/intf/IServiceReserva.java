package com.example.negociorestaurante.Services.intf;

import com.example.modeloRestaurante.entidades.Reserva;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceReserva {
    Reserva agregarReserva(Reserva reserva) throws Exception;
    void actualizarReserva(Reserva reserva) throws Exception;
    void eliminarReserva(Long id) throws Exception;
    Reserva obtenerReserva(Long id) throws Exception;
    List<Reserva> obtenerTodasReservas() throws Exception;
}
