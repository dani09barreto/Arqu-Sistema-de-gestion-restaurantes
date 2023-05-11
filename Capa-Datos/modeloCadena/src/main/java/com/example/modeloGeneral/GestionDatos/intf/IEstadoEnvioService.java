package com.example.modeloGeneral.GestionDatos.intf;

import com.example.entidades.EstadoEnvio;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface IEstadoEnvioService {
    void agregarEstadoEnvio(EstadoEnvio estadoEnvio);
    void actualizarEstadoEnvio(EstadoEnvio estadoEnvio);
    void eliminarEstadoEnvio(Long id);
    EstadoEnvio obtenerEstadoEnvio(Long id);
    List<EstadoEnvio> obtenerTodosEstadosEnvio();
}
