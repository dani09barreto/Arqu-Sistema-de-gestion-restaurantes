package com.example.modeloGeneral.RemoteServiciosData;

import com.example.IRemoteServiciosDatos.IRemoteCantidadIngredienteService;
import com.example.modeloGeneral.GestionDatos.intf.ICantidadIngredienteService;
import com.example.modeloGeneral.GestionDatos.intf.IPlatoService;
import com.example.entidades.CantidadIngrediente;
import com.example.entidades.Plato;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class RemoteCantidadIngredienteService implements IRemoteCantidadIngredienteService {
    @EJB
    ICantidadIngredienteService cantidadIngredienteService;
    @EJB
    IPlatoService platoService;

    @Override
    public void agregarCantidadIngrediente(CantidadIngrediente cantidadIngrediente) {
        cantidadIngredienteService.agregarCantidadIngrediente(cantidadIngrediente);
    }

    @Override
    public void actualizarCantidadIngrediente(CantidadIngrediente cantidadIngrediente) {
        cantidadIngredienteService.actualizarCantidadIngrediente(cantidadIngrediente);
    }

    @Override
    public void eliminarCantidadIngrediente(Long id) {
        cantidadIngredienteService.eliminarCantidadIngrediente(id);
    }

    @Override
    public CantidadIngrediente obtenerCantidadIngrediente(Long id) {
        return cantidadIngredienteService.obtenerCantidadIngrediente(id);
    }

    @Override
    public List<CantidadIngrediente> obtenerTodasCantidadIngredientesPorPlato(Long Platoid) {
        Plato plato = platoService.obtenerPlato(Platoid);
        return cantidadIngredienteService.obtenerTodasCantidadIngredientesPorPlato(plato);
    }
}
