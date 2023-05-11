package com.example.cadenaGeneral.RemoteServiciosData;

import com.example.IRemoteServiciosDatos.IRemoteBodegaService;
import com.example.cadenaGeneral.GestionDatos.intf.IBodegaService;
import com.example.entidades.Bodega;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class RemoteBodegaService implements IRemoteBodegaService {

    @EJB
    IBodegaService bodegaService;

    @Override
    public void agregarBodega(Bodega bodega) {
        bodegaService.agregarBodega(bodega);
    }

    @Override
    public void actualizarBodega(Bodega bodega) {
        bodegaService.actualizarBodega(bodega);
    }

    @Override
    public void eliminarBodega(Long id) {
        bodegaService.eliminarBodega(id);
    }

    @Override
    public Bodega obtenerBodega(Long id) {
        return bodegaService.obtenerBodega(id);
    }

    @Override
    public List<Bodega> obtenerTodasBodegas() {
        return bodegaService.obtenerTodasBodegas();
    }
}
