package com.example.modeloRestaurante.IRemoteServiciosDatos;

import com.example.modeloRestaurante.entidades.Adicionales;
import com.example.modeloRestaurante.entidades.AdicionalesPago;
import jakarta.ejb.Remote;

@Remote
public interface IRemoteAdicionalesPagoService {
    Adicionales obtenerAdicionalesPorPlatoid(long id);
    void AgregarAdicionalesPago(AdicionalesPago adicionalesPago);
}
