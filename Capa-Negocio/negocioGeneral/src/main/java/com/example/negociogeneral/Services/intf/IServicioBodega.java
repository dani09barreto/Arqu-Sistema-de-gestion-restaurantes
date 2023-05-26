package com.example.negociogeneral.Services.intf;

import com.example.entidades.Bodega;
import com.example.negociogeneral.Utils.DistanciaHeap;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.PriorityQueue;

@Service
public interface IServicioBodega {
    List<Bodega> obtenerTodasBodegas() throws Exception;
    void agregarBodega(Bodega bodega) throws Exception;
    void actualizarBodega(Bodega bodega) throws Exception;
    void eliminarBodega(Long id) throws Exception;
    Bodega obtenerBodega(Long id) throws Exception;
    PriorityQueue<DistanciaHeap> obtenerBodegasPorUbicacion(double lat, double lng) throws Exception;
}
