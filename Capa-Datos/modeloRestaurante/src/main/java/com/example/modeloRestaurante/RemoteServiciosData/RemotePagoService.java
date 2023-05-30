package com.example.modeloRestaurante.RemoteServiciosData;

import com.example.modeloRestaurante.IRemoteServiciosDatos.IRemotePagoService;
import com.example.modeloRestaurante.entidades.Pago;
import com.example.modeloRestaurante.GestionDatos.Interfaces.IPagoService;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class RemotePagoService implements IRemotePagoService {
    @EJB
    IPagoService pagoService;

    @Override
    public void agregarPago(Pago pago) {
        pagoService.agregarPago(pago);
    }

    @Override
    public void actualizarPago(Pago pago) {
        pagoService.actualizarPago(pago);
    }

    @Override
    public void eliminarPago(Long id) {
        pagoService.eliminarPago(id);

    }

    @Override
    public Pago obtenerPago(Long id) {
        return pagoService.obtenerPago(id);
    }

    @Override
    public List<Pago> obtenerTodosPagos() {
        return pagoService.obtenerTodosPagos();
    }
}
