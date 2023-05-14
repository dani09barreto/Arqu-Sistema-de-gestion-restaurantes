package com.example.IRemoteServiciosDatos;

import com.example.entidades.Pago;
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
