package com.example.IRemoteServiciosDatos;

import com.example.entidades.TipoIngrediente;
import jakarta.ejb.Remote;

import java.util.List;

@Remote
public interface IRemoteTipoIngredienteService {
    void agregarTipoIngrediente(TipoIngrediente tipoIngrediente);
    void actualizarTipoIngrediente(TipoIngrediente tipoIngrediente);
    void eliminarTipoIngrediente(Long id);
    TipoIngrediente obtenerTipoIngrediente(Long id);
    List<TipoIngrediente> obtenerTodosTipoIngrediente();
}
