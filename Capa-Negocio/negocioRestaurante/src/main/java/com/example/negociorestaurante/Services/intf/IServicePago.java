package com.example.negociorestaurante.Services.intf;

<<<<<<< HEAD
import com.example.entidades.Pago;
=======

import com.example.modeloRestaurante.entidades.Pago;
>>>>>>> develop
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
