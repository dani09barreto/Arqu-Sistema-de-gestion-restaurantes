package com.example.modeloRestaurante.GestionDatos.Interfaces;

import com.example.modeloRestaurante.entidades.Adicionales;
import com.example.modeloRestaurante.entidades.AdicionalesPago;
import jakarta.ejb.Local;

@Local
public interface IAdicionalesPagoService {
    Adicionales obtenerAdicionalesPorPlatoid(long id);
    void AgregarAdicionalesPago(AdicionalesPago adicionalesPago);
}
