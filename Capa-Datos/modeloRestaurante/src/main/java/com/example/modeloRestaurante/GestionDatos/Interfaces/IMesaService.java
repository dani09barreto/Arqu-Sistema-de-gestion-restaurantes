package com.example.modeloRestaurante.GestionDatos.Interfaces;

import com.example.entidades.Mesa;

import java.util.List;

public interface IMesaService {
    void agregarMesa(Mesa mesa);
    void actualizarMesa(Mesa mesa);
    void eliminarMesa(Long id);
    Mesa obtenerMesa(Long id);
    List<Mesa> obtenerTodasMesas();
}
