package com.example.modeloRestaurante.RemoteServiciosData;

import com.example.modeloRestaurante.GestionDatos.Interfaces.IAdicionalesPagoService;
import com.example.modeloRestaurante.IRemoteServiciosDatos.IRemoteAdicionalesPagoService;
import com.example.modeloRestaurante.entidades.Adicionales;
import com.example.modeloRestaurante.entidades.AdicionalesPago;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class RemoteAdicionalesPagoService implements IRemoteAdicionalesPagoService {
    @EJB
    IAdicionalesPagoService iAdicionalesPagoService;
    @Override
    public Adicionales obtenerAdicionalesPorPlatoid(long id) {
        return iAdicionalesPagoService.obtenerAdicionalesPorPlatoid(id);
    }

    @Override
    public void AgregarAdicionalesPago(AdicionalesPago adicionalesPago) {
        iAdicionalesPagoService.AgregarAdicionalesPago(adicionalesPago);
    }
}
