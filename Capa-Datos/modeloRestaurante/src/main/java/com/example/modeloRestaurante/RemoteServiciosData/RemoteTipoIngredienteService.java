package com.example.modeloRestaurante.RemoteServiciosData;

import com.example.IRemoteServiciosDatos.IRemoteTipoIngredienteService;
import com.example.entidades.TipoIngrediente;
import com.example.modeloRestaurante.GestionDatos.Interfaces.ITipoIngredienteService;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class RemoteTipoIngredienteService implements IRemoteTipoIngredienteService {
    @EJB
    ITipoIngredienteService tipoIngredienteService;

    @Override
    public void agregarTipoIngrediente(TipoIngrediente tipoIngrediente) {
        tipoIngredienteService.agregarTipoIngrediente(tipoIngrediente);
    }

    @Override
    public void actualizarTipoIngrediente(TipoIngrediente tipoIngrediente) {
        tipoIngredienteService.actualizarTipoIngrediente(tipoIngrediente);
    }

    @Override
    public void eliminarTipoIngrediente(Long id) {
        tipoIngredienteService.eliminarTipoIngrediente(id);
    }

    @Override
    public TipoIngrediente obtenerTipoIngrediente(Long id) {
        return tipoIngredienteService.obtenerTipoIngrediente(id);
    }

    @Override
    public List<TipoIngrediente> obtenerTodosTipoIngredientes() {
        return tipoIngredienteService.obtenerTodosTipoIngredientes();
    }
}
