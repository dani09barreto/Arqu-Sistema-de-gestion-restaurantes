package com.example.modeloRestaurante.RemoteServiciosData;

import com.example.modeloRestaurante.IRemoteServiciosDatos.IRemoteReservaService;
import com.example.modeloRestaurante.entidades.Reserva;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class RemoteReservaService implements IRemoteReservaService {
    @EJB
    IRemoteReservaService reservaService;

    @Override
    public Reserva agregarReserva(Reserva reserva) {
        return reservaService.agregarReserva(reserva);
    }

    @Override
    public void actualizarReserva(Reserva reserva) {
        reservaService.actualizarReserva(reserva);
    }

    @Override
    public void eliminarReserva(Long id) {
        reservaService.eliminarReserva(id);
    }

    @Override
    public Reserva obtenerReserva(Long id) {
        return reservaService.obtenerReserva(id);
    }

    @Override
    public List<Reserva> obtenerTodasReservas() {
        return reservaService.obtenerTodasReservas();
    }
}
