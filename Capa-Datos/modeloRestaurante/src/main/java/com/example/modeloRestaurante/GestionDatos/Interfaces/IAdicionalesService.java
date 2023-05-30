package com.example.modeloRestaurante.GestionDatos.Interfaces;

import com.example.modeloRestaurante.entidades.Adicionales;
import jakarta.ejb.Local;

import java.util.List;
@Local
public interface IAdicionalesService {
    void agregarAdicionales(Adicionales adicionales);
    void actualizarAdicionales(Adicionales adicionales);
    void eliminarAdicionales(Long id);
    Adicionales obtenerAdicionales(Long id);
    List<Adicionales> obtenerTodasAdicionales();
}
