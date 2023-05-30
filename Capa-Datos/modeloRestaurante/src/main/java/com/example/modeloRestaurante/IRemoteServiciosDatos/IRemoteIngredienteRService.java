package com.example.IRemoteServiciosDatos;

import com.example.entidades.IngredienteR;
import jakarta.ejb.Remote;

import java.util.List;
@Remote
public interface IRemoteIngredienteRService {
    void agregarIngrediente(IngredienteR ingrediente);
    void actualizarIngrediente(IngredienteR ingrediente);
    void eliminarIngrediente(Long id);
    IngredienteR obtenerIngrediente(Long id);
    List<IngredienteR> obtenerTodosIngredientes();
}
