package com.example.IRemoteServiciosDatos;

import com.example.entidades.CantidadIngrediente;
import jakarta.ejb.Remote;

import java.util.List;

@Remote
public interface IRemoteCantidadIngredienteService {
    void agregarCantidadIngrediente(CantidadIngrediente cantidadIngrediente);
    void actualizarCantidadIngrediente(CantidadIngrediente cantidadIngrediente);
    void eliminarCantidadIngrediente(Long id);
    CantidadIngrediente obtenerCantidadIngrediente(Long id);
}
