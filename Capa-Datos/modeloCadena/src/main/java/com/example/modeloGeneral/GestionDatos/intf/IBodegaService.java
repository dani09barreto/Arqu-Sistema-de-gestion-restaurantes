package com.example.modeloGeneral.GestionDatos.intf;

import com.example.entidades.Bodega;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface IBodegaService {
    void agregarBodega(Bodega bodega);
    void actualizarBodega(Bodega bodega);
    void eliminarBodega(Long id);
    Bodega obtenerBodega(Long id);
    List<Bodega> obtenerTodasBodegas();
}
