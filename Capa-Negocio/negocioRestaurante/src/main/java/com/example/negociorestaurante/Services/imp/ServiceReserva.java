package com.example.negociorestaurante.Services.imp;

import com.example.modeloRestaurante.entidades.Reserva;
import com.example.negociorestaurante.ServiceLocator.IServiceLocator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ServiceReserva{
    @Autowired
    @Qualifier("serviceLocator")
    private IServiceLocator serviceLocator;

    public Reserva agregarReserva(Reserva reserva) throws Exception {
        return serviceLocator.getRemoteReservaService().agregarReserva(reserva);
    }


    public void actualizarReserva(Reserva reserva) throws Exception {
        serviceLocator.getRemoteReservaService().actualizarReserva(reserva);
    }


}
