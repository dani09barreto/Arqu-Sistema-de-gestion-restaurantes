package com.example.modeloRestaurante.IRemoteServiciosDatos;

import com.example.modeloRestaurante.entidades.Adicionales;
import jakarta.ejb.Remote;

import java.util.List;
@Remote
public interface IRemoteAdicionalesService {
    void agregarAdicionales(Adicionales adicionales);
    void actualizarAdicionales(Adicionales adicionales);
    void eliminarAdicionales(Long id);
    Adicionales obtenerAdicionales(Long id);
    List<Adicionales> obtenerTodasAdicionales();
}
