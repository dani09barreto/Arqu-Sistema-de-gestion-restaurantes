package com.example.modeloGeneral.RemoteServiciosData;

import com.example.IRemoteServiciosDatos.IRemoteEnvioInventarioService;
import com.example.entidades.EnvioInventario;
import com.example.entidades.EstadoEnvio;
import com.example.entidades.Restaurante;
import com.example.modeloGeneral.GestionDatos.intf.IEnvioInventarioService;
import com.example.modeloGeneral.GestionDatos.intf.IEstadoEnvioService;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class RemoteEnvioInventarioService implements IRemoteEnvioInventarioService {
    @EJB
    IEnvioInventarioService envioInventarioService;
    @EJB
    IEstadoEnvioService estadoEnvioService;

    @Override
    public EnvioInventario agregarEnvioInventario(EnvioInventario envioInventario) {
        return envioInventarioService.agregarEnvioInventario(envioInventario);
    }

    @Override
    public void actualizarEnvioInventario(Long idEnvioinventario, String estado) {
        EstadoEnvio estadoEnvio = estadoEnvioService.obtenerEstadoEnvioPorNombre(estado);
        EnvioInventario envioInventario = envioInventarioService.obtenerEnvioInventario(idEnvioinventario);
        envioInventario.setEstadoEnvio(estadoEnvio);
        envioInventarioService.actualizarEnvioInventario(envioInventario);
    }

    @Override
    public void eliminarEnvioInventario(Long id) {
        envioInventarioService.eliminarEnvioInventario(id);
    }

    @Override
    public EnvioInventario obtenerEnvioInventario(Long id) {
        return envioInventarioService.obtenerEnvioInventario(id);
    }

    @Override
    public List<EnvioInventario> obtenerTodosEnvioInventarioPorRestaurante(Restaurante restaurante) {
        return envioInventarioService.obtenerTodosEnvioInventarioPorRestaurante(restaurante);
    }
}
