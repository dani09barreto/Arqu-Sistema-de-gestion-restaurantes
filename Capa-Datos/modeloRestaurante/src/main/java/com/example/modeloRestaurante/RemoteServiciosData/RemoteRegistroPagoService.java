package com.example.modeloRestaurante.RemoteServiciosData;

import com.example.modeloRestaurante.IRemoteServiciosDatos.IRemoteRegistroPagoService;
import com.example.modeloRestaurante.entidades.RegistroPago;
import com.example.modeloRestaurante.GestionDatos.Interfaces.IRegistroPagoService;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class RemoteRegistroPagoService implements IRemoteRegistroPagoService {
    @EJB
    IRegistroPagoService registroPagoService;

    @Override
    public void agregarRegistroPago(RegistroPago registroPago) {
        registroPagoService.agregarRegistroPago(registroPago);
    }

    @Override
    public void actualizarRegistroPago(RegistroPago registroPago) {
        registroPagoService.actualizarRegistroPago(registroPago);

    }

    @Override
    public void eliminarRegistroPago(Long id) {
        registroPagoService.eliminarRegistroPago(id);
    }

    @Override
    public RegistroPago obtenerRegistroPago(Long id) {
        return registroPagoService.obtenerRegistroPago(id);
    }

    @Override
    public List<RegistroPago> obtenerTodosRegistroPagos() {
        return registroPagoService.obtenerTodosRegistroPagos();
    }
}
