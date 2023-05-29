package com.example.modeloRestaurante.RemoteServiciosData;

import com.example.IRemoteServiciosDatos.IRemoteTipoPagoService;
import com.example.entidades.TipoPago;
import com.example.modeloRestaurante.GestionDatos.Interfaces.ITipoPagoService;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class RemoteTipoPagoService implements IRemoteTipoPagoService {
    @EJB
    ITipoPagoService tipoPagoService;

    @Override
    public void agregarTipoPago(TipoPago tipoPago) {
        tipoPagoService.agregarTipoPago(tipoPago);
    }

    @Override
    public void actualizarTipoPago(TipoPago tipoPago) {
        tipoPagoService.actualizarTipoPago(tipoPago);
    }

    @Override
    public void eliminarTipoPago(Long id) {
        tipoPagoService.eliminarTipoPago(id);
    }

    @Override
    public TipoPago obtenerTipoPago(Long id) {
        return tipoPagoService.obtenerTipoPago(id);
    }

    @Override
    public List<TipoPago> obtenerTodosTipoPagos() {
        return tipoPagoService.obtenerTodosTipoPagos();
    }

    @Override
    public TipoPago obtenerTipoPagoPorNombre(String nombre) {
        return tipoPagoService.obtenerTipoPagoPorNombre(nombre);
    }
}
