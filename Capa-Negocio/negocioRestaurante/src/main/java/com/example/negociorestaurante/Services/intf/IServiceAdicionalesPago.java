package com.example.negociorestaurante.Services.intf;

import com.example.modeloRestaurante.entidades.Adicionales;
import com.example.modeloRestaurante.entidades.AdicionalesPago;
import org.springframework.stereotype.Service;

@Service
public interface IServiceAdicionalesPago {
    Adicionales obtenerAdicionalesPorPlatoid(long id) throws Exception;
    void AgregarAdicionalesPago(AdicionalesPago adicionalesPago) throws Exception;
}
