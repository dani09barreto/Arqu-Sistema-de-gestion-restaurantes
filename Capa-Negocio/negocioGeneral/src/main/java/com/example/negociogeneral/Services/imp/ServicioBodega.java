package com.example.negociogeneral.Services.imp;

import com.example.entidades.Bodega;
import com.example.negociogeneral.ServiceLocator.IServiceLocator;
import com.example.negociogeneral.Services.intf.IServicioBodega;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioBodega implements IServicioBodega {

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
}
