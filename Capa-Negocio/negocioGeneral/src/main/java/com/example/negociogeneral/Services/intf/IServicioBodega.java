package com.example.negociogeneral.Services.intf;

import com.example.entidades.Bodega;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServicioBodega {
    List<Bodega> obtenerTodasBodegas() throws Exception;
    void agregarBodega(Bodega bodega) throws Exception;
    void actualizarBodega(Bodega bodega) throws Exception;
    void eliminarBodega(Long id) throws Exception;
}
