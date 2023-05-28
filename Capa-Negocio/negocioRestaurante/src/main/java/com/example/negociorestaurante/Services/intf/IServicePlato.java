package com.example.negociorestaurante.Services.intf;

import com.example.entidades.PlatoR;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServicePlato {
    void agregarPlato(PlatoR plato) throws Exception;
    void actualizarPlato(PlatoR plato) throws Exception;
    void eliminarPlato(Long id) throws Exception;
    PlatoR obtenerPlato(Long id) throws Exception;
    List<PlatoR> obtenerTodosPlato() throws Exception;
}