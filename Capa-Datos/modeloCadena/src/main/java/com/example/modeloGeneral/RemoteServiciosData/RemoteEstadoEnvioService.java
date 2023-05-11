package com.example.modeloGeneral.RemoteServiciosData;

import com.example.IRemoteServiciosDatos.IRemoteEstadoEnvioService;
import com.example.modeloGeneral.GestionDatos.intf.IEstadoEnvioService;
import com.example.entidades.EstadoEnvio;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class RemoteEstadoEnvioService implements IRemoteEstadoEnvioService {

    @EJB
    IEstadoEnvioService estadoEnvioService;

    @Override
    public void agregarEstadoEnvio(EstadoEnvio estadoEnvio) {
        estadoEnvioService.agregarEstadoEnvio(estadoEnvio);
    }

    @Override
    public void actualizarEstadoEnvio(EstadoEnvio estadoEnvio) {
        estadoEnvioService.actualizarEstadoEnvio(estadoEnvio);
    }

    @Override
    public void eliminarEstadoEnvio(Long id) {
        estadoEnvioService.eliminarEstadoEnvio(id);
    }

    @Override
    public EstadoEnvio obtenerEstadoEnvio(Long id) {
        return estadoEnvioService.obtenerEstadoEnvio(id);
    }

    @Override
    public List<EstadoEnvio> obtenerTodosEstadosEnvio() {
        return estadoEnvioService.obtenerTodosEstadosEnvio();
    }
}
