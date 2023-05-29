package com.example.IRemoteServiciosDatos;

import com.example.entidades.EnvioInventario;
import com.example.entidades.Restaurante;
import jakarta.ejb.Remote;

import java.util.List;

@Remote
public interface IRemoteEnvioInventarioService {
    EnvioInventario agregarEnvioInventario(EnvioInventario envioInventario);
    void actualizarEnvioInventario(Long idEnvioinventario, String estado);
    void eliminarEnvioInventario(Long id);
    EnvioInventario obtenerEnvioInventario(Long id);
    List<EnvioInventario> obtenerTodosEnvioInventarioPorRestaurante(Restaurante restaurante);
}
