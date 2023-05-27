package com.example.modeloRestaurante.RemoteServiciosData;

import com.example.IRemoteServiciosDatos.IRemotePlatoService;
import com.example.entidades.Plato;
import com.example.modeloRestaurante.GestionDatos.Interfaces.IPlatoService;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;
@Stateless
public class RemotePlatoService implements IRemotePlatoService {
    @EJB
    IPlatoService platoService;
    @Override
    public void agregarPlato(Plato plato) {
        platoService.agregarPlato(plato);
    }

    @Override
    public void actualizarPlato(Plato plato) {
        platoService.actualizarPlato(plato);
    }

    @Override
    public void eliminarPlato(Long id) {
        platoService.eliminarPlato(id);
    }

    @Override
    public Plato obtenerPlato(Long id) {
        return platoService.obtenerPlato(id);
    }

    @Override
    public List<Plato> obtenerTodosPlato() {
        return platoService.obtenerTodosPlato();
    }
}
