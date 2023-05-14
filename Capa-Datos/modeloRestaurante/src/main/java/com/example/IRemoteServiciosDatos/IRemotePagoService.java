package com.example.IRemoteServiciosDatos;

import com.example.entidades.Pago;

import java.util.List;

public interface IRemotePagoService {
    void agregarPago(Pago pago);
    void actualizarPago(Pago pago);
    void eliminarPago(Long id);
    Pago obtenerPago(Long id);
    List<Pago> obtenerTodosPagos();
}
