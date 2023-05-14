package com.example.IRemoteServiciosDatos;

import com.example.entidades.Mesa;

import java.util.List;

public interface IRemoteMesaService {
    void agregarMesa(Mesa mesa);
    void actualizarMesa(Mesa mesa);
    void eliminarMesa(Long id);
    Mesa obtenerMesa(Long id);
    List<Mesa> obtenerTodasMesas();
}
