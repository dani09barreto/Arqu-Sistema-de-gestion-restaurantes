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

    private static final int DISTANCIA_MAXIMA = 6;

    @Autowired
    @Qualifier("serviceLocator")
    private IServiceLocator serviceLocator;

    @Override
    public List<Bodega> obtenerTodasBodegas() throws Exception {
        return serviceLocator.getRemoteBodegaService().obtenerTodasBodegas();
    }

    @Override
    public void agregarBodega(Bodega bodega) throws Exception {
        serviceLocator.getRemoteBodegaService().agregarBodega(bodega);
    }

    @Override
    public void actualizarBodega(Bodega bodega) throws Exception {
        serviceLocator.getRemoteBodegaService().actualizarBodega(bodega);
    }

    @Override
    public void eliminarBodega(Long id) throws Exception {
        serviceLocator.getRemoteBodegaService().eliminarBodega(id);
    }

    @Override
    public Bodega obtenerBodega(Long id) throws Exception {
        return serviceLocator.getRemoteBodegaService().obtenerBodega(id);
    }

    @Override
    public PriorityQueue <DistanciaHeap> obtenerBodegasPorUbicacion(double lat, double lng) throws Exception {
        PriorityQueue <DistanciaHeap> heap = new PriorityQueue<>();

        for (Bodega bodega : serviceLocator.getRemoteBodegaService().obtenerTodasBodegas()) {
            int distancia = DistanceUtils.calculateDistanceInKilometer(lat, lng, bodega.getLat(), bodega.getLng());
            if (distancia <= DISTANCIA_MAXIMA){
                heap.add(new DistanciaHeap(bodega.getId(), distancia));
            }
        }
        return heap;
    }
}
