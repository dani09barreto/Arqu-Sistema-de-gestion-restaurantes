package com.example.IRemoteServiciosDatos;

import com.example.entidades.Reserva;
import com.example.entidades.TipoIngrediente;
import jakarta.ejb.Remote;

import java.util.List;

@Remote
public interface IRemoteReservaService {
    Reserva agregarReserva(TipoIngrediente tipoIngrediente);
    void actualizarReserva(TipoIngrediente tipoIngrediente);
    void eliminarReserva(Long id);
    TipoIngrediente obtenerReserva(Long id);
    List<TipoIngrediente> obtenerTodosTipoIngredientes();
}
