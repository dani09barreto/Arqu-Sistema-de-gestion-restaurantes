package com.example.modeloRestaurante.RemoteServiciosData;

import com.example.modeloRestaurante.IRemoteServiciosDatos.IRemoteIngredienteService;
import com.example.modeloRestaurante.entidades.Ingrediente;
import com.example.modeloRestaurante.GestionDatos.Interfaces.IIngredienteService;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class RemoteIngredienteService implements IRemoteIngredienteService {
    @EJB
    IIngredienteService iIngredienteService;

    @Override
    public void agregarIngrediente(Ingrediente ingrediente) {
        iIngredienteService.agregarIngrediente(ingrediente);
    }

    @Override
    public void actualizarIngrediente(Ingrediente ingrediente) {
        iIngredienteService.actualizarIngrediente(ingrediente);

    }

    @Override
    public void eliminarIngrediente(Long id) {
        iIngredienteService.eliminarIngrediente(id);
    }

    @Override
    public Ingrediente obtenerIngrediente(Long id) {
        return iIngredienteService.obtenerIngrediente(id);
    }

    @Override
    public List<Ingrediente> obtenerTodosIngredientes() {
        return iIngredienteService.obtenerTodosIngredientes();
    }
}
