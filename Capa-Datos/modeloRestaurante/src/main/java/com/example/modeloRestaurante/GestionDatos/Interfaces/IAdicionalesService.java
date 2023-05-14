package com.example.modeloRestaurante.GestionDatos.Interfaces;

import com.example.entidades.Adicionales;

import java.util.List;

public interface IAdicionalesService {
    void agregarAdicionales(Adicionales adicionales);
    void actualizarAdicionales(Adicionales adicionales);
    void eliminarAdicionales(Long id);
    Adicionales obtenerAdicionales(Long id);
    List<Adicionales> obtenerTodasAdicionales();
}
