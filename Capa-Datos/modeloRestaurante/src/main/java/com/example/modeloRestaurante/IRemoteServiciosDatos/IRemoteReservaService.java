package com.example.modeloRestaurante.IRemoteServiciosDatos;

import com.example.modeloRestaurante.entidades.Reserva;
import com.example.modeloRestaurante.entidades.TipoIngrediente;
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
