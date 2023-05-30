package com.example.modeloRestaurante.IRemoteServiciosDatos;

import com.example.modeloRestaurante.entidades.TipoPago;
import jakarta.ejb.Remote;

import java.util.List;
@Remote
public interface IRemoteTipoPagoService {
    void agregarTipoPago(TipoPago tipoPago);
    void actualizarTipoPago(TipoPago tipoPago);
    void eliminarTipoPago(Long id);
    TipoPago obtenerTipoPago(Long id);
    List<TipoPago> obtenerTodosTipoPagos();
    TipoPago obtenerTipoPagoPorNombre(String nombre);
}
