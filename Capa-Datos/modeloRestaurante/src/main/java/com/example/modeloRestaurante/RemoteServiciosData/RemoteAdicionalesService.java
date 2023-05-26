package com.example.modeloRestaurante.RemoteServiciosData;

import com.example.IRemoteServiciosDatos.IRemoteAdicionalesService;
import com.example.entidades.Adicionales;
import com.example.modeloRestaurante.GestionDatos.Interfaces.IAdicionalesService;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class RemoteAdicionalesService implements IRemoteAdicionalesService {

    @EJB
    IAdicionalesService adicionalesService;

    @Override
    public void agregarAdicionales(Adicionales adicionales) {
        adicionalesService.agregarAdicionales(adicionales);
    }

    @Override
    public void actualizarAdicionales(Adicionales adicionales) {
        adicionalesService.actualizarAdicionales(adicionales);
    }

    @Override
    public void eliminarAdicionales(Long id) {
        adicionalesService.eliminarAdicionales(id);
    }

    @Override
    public Adicionales obtenerAdicionales(Long id) {
        return adicionalesService.obtenerAdicionales(id);
    }

    @Override
    public List<Adicionales> obtenerTodasAdicionales() {
        return adicionalesService.obtenerTodasAdicionales();
    }
}
