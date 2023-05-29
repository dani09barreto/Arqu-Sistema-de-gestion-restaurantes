package com.example.negociorestaurante.Services.intf;

import com.example.entidades.RegistroPago;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceRegistroPago {
    void agregarRegistroPago(RegistroPago registroPago);
    void actualizarRegistroPago(RegistroPago registroPago);
    void eliminarRegistroPago(Long id);
    RegistroPago obtenerRegistroPago(Long id);
    List<RegistroPago> obtenerTodosRegistroPagos();
}
