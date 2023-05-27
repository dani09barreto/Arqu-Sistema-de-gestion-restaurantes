package com.example.IRemoteServiciosDatos;

import com.example.entidades.Plato;
import jakarta.ejb.Remote;

import java.util.List;

@Remote
public interface IRemotePlatoService {
    void agregarPlato(Plato plato);
    void actualizarPlato(Plato plato);
    void eliminarPlato(Long id);
    Plato obtenerPlato(Long id);
    List<Plato> obtenerTodosPlato();
}
