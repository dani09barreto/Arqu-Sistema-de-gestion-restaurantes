package com.example.modeloGeneral.RemoteServiciosData;

import com.example.IRemoteServiciosDatos.IRemoteIngredienteService;
import com.example.modeloGeneral.GestionDatos.intf.IIngredienteService;
import com.example.modeloGeneral.GestionDatos.intf.ITipoIngredienteService;
import com.example.entidades.Ingrediente;
import com.example.entidades.TipoIngrediente;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class RemoteIngredienteService implements IRemoteIngredienteService {
    @EJB
    IIngredienteService ingredienteService;
    @EJB
    ITipoIngredienteService tipoIngredienteService;

    @Override
    public void agregarIngrediente(Ingrediente ingrediente) {

    }

    @Override
    public void actualizarIngrediente(Ingrediente ingrediente) {
        ingredienteService.agregarIngrediente(ingrediente);
    }

    @Override
    public void eliminarIngrediente(Long id) {
        ingredienteService.eliminarIngrediente(id);
    }

    @Override
    public Ingrediente obtenerIngrediente(Long id) {
        return ingredienteService.obtenerIngrediente(id);
    }

    @Override
    public List<Ingrediente> obtenerIngredientesPorTipo(Long TipoIngredienteid) {
        TipoIngrediente tipoIngrediente = tipoIngredienteService.obtenerTipoIngrediente(TipoIngredienteid);
        return ingredienteService.obtenerIngredientesPorTipo(tipoIngrediente);
    }
}
