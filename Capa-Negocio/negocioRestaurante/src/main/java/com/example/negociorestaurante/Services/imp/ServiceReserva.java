package com.example.negociorestaurante.Services.imp;

import com.example.modeloRestaurante.entidades.Reserva;
import com.example.negociorestaurante.ServiceLocator.IServiceLocator;
import com.example.negociorestaurante.Services.intf.IServiceReserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceReserva implements IServiceReserva {
    @Autowired
    @Qualifier("serviceLocator")
    private IServiceLocator serviceLocator;
    @Override
    public Reserva agregarReserva(Reserva reserva) throws Exception {
        return serviceLocator.getRemoteReservaService().agregarReserva(reserva);
    }

    @Override
    public void actualizarReserva(Reserva reserva) throws Exception {
        serviceLocator.getRemoteReservaService().actualizarReserva(reserva);
    }

    @Override
    public void eliminarReserva(Long id) throws Exception {
        serviceLocator.getRemoteReservaService().eliminarReserva(id);
    }

    @Override
    public Reserva obtenerReserva(Long id) throws Exception {
        return serviceLocator.getRemoteReservaService().obtenerReserva(id);
    }

    @Override
    public List<Reserva> obtenerTodasReservas() throws Exception {
        return serviceLocator.getRemoteReservaService().obtenerTodasReservas();
    }
}
