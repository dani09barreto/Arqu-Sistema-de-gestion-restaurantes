package com.example.IRemoteServiciosDatos;

import com.example.entidades.EstadoEnvio;
import jakarta.ejb.Remote;

import java.util.List;

@Remote
public interface IRemoteEstadoEnvioService {
    void agregarEstadoEnvio(EstadoEnvio estadoEnvio);
    void actualizarEstadoEnvio(EstadoEnvio estadoEnvio);
    void eliminarEstadoEnvio(Long id);
    EstadoEnvio obtenerEstadoEnvio(Long id);
    EstadoEnvio obtenerEstadoEnvioPorNombre(String nombre);
    List<EstadoEnvio> obtenerTodosEstadosEnvio();
}
