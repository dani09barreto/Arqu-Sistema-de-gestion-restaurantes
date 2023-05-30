package com.example.modeloRestaurante.IRemoteServiciosDatos;

import com.example.modeloRestaurante.entidades.Pago;
import jakarta.ejb.Remote;

import java.util.List;
@Remote
public interface IRemotePagoService {
    void agregarPago(Pago pago);
    void actualizarPago(Pago pago);
    void eliminarPago(Long id);
    Pago obtenerPago(Long id);
    List<Pago> obtenerTodosPagos();
}
