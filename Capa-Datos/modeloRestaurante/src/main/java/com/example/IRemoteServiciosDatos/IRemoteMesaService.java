package com.example.IRemoteServiciosDatos;

import com.example.entidades.Mesa;
import jakarta.ejb.Remote;

import java.util.List;
@Remote
public interface IRemoteMesaService {
    void agregarMesa(Mesa mesa);
    void actualizarMesa(Mesa mesa);
    void eliminarMesa(Long id);
    Mesa obtenerMesa(Long id);
    List<Mesa> obtenerTodasMesas();
}
