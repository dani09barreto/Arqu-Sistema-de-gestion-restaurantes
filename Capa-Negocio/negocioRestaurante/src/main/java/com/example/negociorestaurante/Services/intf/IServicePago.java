package com.example.negociorestaurante.Services.intf;


import com.example.modeloRestaurante.entidades.Pago;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IServicePago {
    void agregarPago(Pago pago) throws Exception;
    void actualizarPago(Pago pago) throws Exception;
    void eliminarPago(Long id) throws Exception;
    Pago obtenerPago(Long id) throws Exception;
    List<Pago> obtenerTodosPagos() throws Exception;
}
