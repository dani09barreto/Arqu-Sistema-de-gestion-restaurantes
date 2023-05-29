package com.example.negociogeneral.Services.imp;

import com.example.entidades.Bodega;
import com.example.negociogeneral.ServiceLocator.IServiceLocator;
import com.example.negociogeneral.Services.intf.IServicioBodega;
import com.example.negociogeneral.Utils.DistanceUtils;
import com.example.negociogeneral.Utils.DistanciaHeap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

@Service
public class ServicioBodega implements IServicioBodega {

    private static final int DISTANCIA_MAXIMA = 7;

    @Autowired
    @Qualifier("serviceLocator")
    private IServiceLocator serviceLocator;

    @Override
    public List<Bodega> obtenerTodasBodegas(String uri) throws Exception {
        return serviceLocator.getRemoteBodegaService(uri).obtenerTodasBodegas();
    }

    @Override
    public void agregarBodega(Bodega bodega, String uri) throws Exception {
        serviceLocator.getRemoteBodegaService(uri).agregarBodega(bodega);
    }

    @Override
    public void actualizarBodega(Bodega bodega, String uri) throws Exception {
        serviceLocator.getRemoteBodegaService(uri).actualizarBodega(bodega);
    }

    @Override
    public void eliminarBodega(Long id, String uri) throws Exception {
        serviceLocator.getRemoteBodegaService(uri).eliminarBodega(id);
    }

    @Override
    public Bodega obtenerBodega(Long id, String uri) throws Exception {
        return serviceLocator.getRemoteBodegaService(uri).obtenerBodega(id);
    }

    @Override
    public PriorityQueue <DistanciaHeap> obtenerBodegasPorUbicacion(double lat, double lng, String uri) throws Exception {
        PriorityQueue <DistanciaHeap> heap = new PriorityQueue<>();

        for (Bodega bodega : serviceLocator.getRemoteBodegaService(uri).obtenerTodasBodegas()) {
            int distancia = DistanceUtils.calculateDistanceInKilometer(lat, lng, bodega.getLat(), bodega.getLng());
            if (distancia <= DISTANCIA_MAXIMA){
                heap.add(new DistanciaHeap(bodega.getId(), distancia));
            }
        }
        return heap;
    }
}
