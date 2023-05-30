package com.example.negociogeneral.Services.intf;

import com.example.entidades.Bodega;
import com.example.negociogeneral.Utils.DistanciaHeap;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.PriorityQueue;

@Service
public interface IServicioBodega {
    List<Bodega> obtenerTodasBodegas(String uri) throws Exception;
    void agregarBodega(Bodega bodega, String uri) throws Exception;
    void actualizarBodega(Bodega bodega, String uri) throws Exception;
    void eliminarBodega(Long id, String uri) throws Exception;
    Bodega obtenerBodega(Long id, String uri) throws Exception;
    PriorityQueue<DistanciaHeap> obtenerBodegasPorUbicacion(double lat, double lng, String uri) throws Exception;
}
