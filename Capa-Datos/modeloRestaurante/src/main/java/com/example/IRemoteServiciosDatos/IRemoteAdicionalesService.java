package com.example.IRemoteServiciosDatos;

import com.example.entidades.Adicionales;
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
