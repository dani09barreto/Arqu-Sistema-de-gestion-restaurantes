package com.example.modeloGeneral.GestionDatos.intf;

import com.example.entidades.EnvioInventario;
import com.example.entidades.Restaurante;
import jakarta.ejb.Local;

import java.util.Date;
import java.util.List;

@Local
public interface IEnvioInventarioService {
    EnvioInventario agregarEnvioInventario(EnvioInventario envioInventario);
    void actualizarEnvioInventario(EnvioInventario envioInventario);
    void eliminarEnvioInventario(Long id);
    EnvioInventario obtenerEnvioInventario(Long id);
    List<EnvioInventario> obtenerTodosEnvioInventarioPorRestaurante(Restaurante restaurante);
}
