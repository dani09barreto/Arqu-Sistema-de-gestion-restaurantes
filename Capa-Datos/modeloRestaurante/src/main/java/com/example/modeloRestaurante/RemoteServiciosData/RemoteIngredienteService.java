package com.example.modeloRestaurante.RemoteServiciosData;

import com.example.IRemoteServiciosDatos.IRemoteIngredienteRService;
import com.example.entidades.IngredienteR;
import com.example.modeloRestaurante.GestionDatos.Interfaces.IIngredienteService;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class RemoteIngredienteService implements IRemoteIngredienteRService {
    @EJB
    IIngredienteService iIngredienteService;

    @Override
    public void agregarIngrediente(IngredienteR ingrediente) {
        iIngredienteService.agregarIngrediente(ingrediente);
    }

    @Override
    public void actualizarIngrediente(IngredienteR ingrediente) {
        iIngredienteService.actualizarIngrediente(ingrediente);

    }

    @Override
    public void eliminarIngrediente(Long id) {
        iIngredienteService.eliminarIngrediente(id);
    }

    @Override
    public IngredienteR obtenerIngrediente(Long id) {
        return iIngredienteService.obtenerIngrediente(id);
    }

    @Override
    public List<IngredienteR> obtenerTodosIngredientes() {
        return iIngredienteService.obtenerTodosIngredientes();
    }
}
