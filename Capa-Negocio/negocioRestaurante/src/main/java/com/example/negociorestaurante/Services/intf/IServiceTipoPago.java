package com.example.negociorestaurante.Services.intf;


import com.example.modeloRestaurante.entidades.TipoPago;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceTipoPago {

    void agregarTipoPago(TipoPago tipoPago) throws Exception;

    void actualizarTipoPago(TipoPago tipoPago) throws Exception;

    void eliminarTipoPago(Long id) throws Exception;

    TipoPago obtenerTipoPago(Long id) throws Exception;

    List<TipoPago> obtenerTodosTipoPagos() throws Exception;

    TipoPago obtenerTipoPagoPorNombre(String nombre) throws Exception;

}
