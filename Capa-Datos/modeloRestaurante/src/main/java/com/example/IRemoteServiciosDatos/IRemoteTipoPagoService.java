package com.example.IRemoteServiciosDatos;

import com.example.entidades.TipoPago;
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
