package com.example.modeloGeneral.RemoteServiciosData;

import com.example.IRemoteServiciosDatos.IRemoteEnvioInventarioService;
import com.example.entidades.EnvioInventario;
import com.example.entidades.Restaurante;
import com.example.modeloGeneral.GestionDatos.intf.IEnvioInventarioService;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class RemoteEnvioInventarioService implements IRemoteEnvioInventarioService {
    @EJB
    IEnvioInventarioService envioInventarioService;

    @Override
    public EnvioInventario agregarEnvioInventario(EnvioInventario envioInventario) {
        return envioInventarioService.agregarEnvioInventario(envioInventario);
    }

    @Override
    public void actualizarEnvioInventario(EnvioInventario envioInventario) {
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
