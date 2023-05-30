package com.example.negociorestaurante.Services.intf;

import com.example.modeloRestaurante.entidades.RegistroPago;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceRegistroPago {
    void agregarRegistroPago(RegistroPago registroPago) throws Exception;
    void actualizarRegistroPago(RegistroPago registroPago) throws Exception;
    void eliminarRegistroPago(Long id) throws Exception;
    RegistroPago obtenerRegistroPago(Long id) throws Exception;
    List<RegistroPago> obtenerTodosRegistroPagos() throws Exception;
}
