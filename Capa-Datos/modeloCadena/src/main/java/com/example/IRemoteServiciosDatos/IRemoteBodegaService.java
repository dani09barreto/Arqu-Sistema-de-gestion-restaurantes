package com.example.IRemoteServiciosDatos;

import com.example.entidades.Bodega;
import jakarta.ejb.Remote;

import java.util.List;

@Remote
public interface IRemoteBodegaService {
    void agregarBodega(Bodega bodega);
    void actualizarBodega(Bodega bodega);
    void eliminarBodega(Long id);
    Bodega obtenerBodega(Long id);
    List <Bodega> obtenerTodasBodegas();
}
