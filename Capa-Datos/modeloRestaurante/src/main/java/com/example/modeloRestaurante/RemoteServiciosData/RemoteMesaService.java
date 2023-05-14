package com.example.modeloRestaurante.RemoteServiciosData;

import com.example.IRemoteServiciosDatos.IRemoteMesaService;
import com.example.entidades.Mesa;
import com.example.modeloRestaurante.GestionDatos.Interfaces.IMesaService;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class RemoteMesaService implements IRemoteMesaService {
    @EJB
    IMesaService mesaService;

    @Override
    public void agregarMesa(Mesa mesa) {
        mesaService.agregarMesa(mesa);
    }

    @Override
    public void actualizarMesa(Mesa mesa) {
        mesaService.actualizarMesa(mesa);
    }

    @Override
    public void eliminarMesa(Long id) {
        mesaService.eliminarMesa(id);
    }

    @Override
    public Mesa obtenerMesa(Long id) {
        return mesaService.obtenerMesa(id);
    }

    @Override
    public List<Mesa> obtenerTodasMesas() {
        return mesaService.obtenerTodasMesas();
    }
}
