package com.example.modeloRestaurante.RemoteServiciosData;

import com.example.IRemoteServiciosDatos.IRemoteDescuentoFidelidadService;
import com.example.entidades.DescuentoFidelidad;
import com.example.modeloRestaurante.GestionDatos.Interfaces.IDescuentoFidelidadService;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class RemoteDescuentoFidelidadService implements IRemoteDescuentoFidelidadService {
    @EJB
    IDescuentoFidelidadService descuentoFidelidadService;

    @Override
    public void agregarDescuentoFidelidad(DescuentoFidelidad descuentoFidelidad) {
        descuentoFidelidadService.agregarDescuentoFidelidad(descuentoFidelidad);
    }

    @Override
    public void actualizarDescuentoFidelidad(DescuentoFidelidad descuentoFidelidad) {
        descuentoFidelidadService.actualizarDescuentoFidelidad(descuentoFidelidad);
    }

    @Override
    public void eliminarDescuentoFidelidad(Long id) {
        descuentoFidelidadService.eliminarDescuentoFidelidad(id);
    }

    @Override
    public DescuentoFidelidad obtenerDescuentoFidelidad(Long id) {
        return descuentoFidelidadService.obtenerDescuentoFidelidad(id);
    }

    @Override
    public List<DescuentoFidelidad> obtenerTodosDescuentosFidelidad() {
        return descuentoFidelidadService.obtenerTodosDescuentosFidelidad();
    }
}
