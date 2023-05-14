package com.example.modeloRestaurante.GestionDatos.Interfaces;

import com.example.entidades.Mesa;
import jakarta.ejb.Local;

import java.util.List;
@Local
public interface IMesaService {
    void agregarMesa(Mesa mesa);
    void actualizarMesa(Mesa mesa);
    void eliminarMesa(Long id);
    Mesa obtenerMesa(Long id);
    List<Mesa> obtenerTodasMesas();
}
