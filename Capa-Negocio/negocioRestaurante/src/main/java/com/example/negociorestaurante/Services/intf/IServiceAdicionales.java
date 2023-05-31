package com.example.negociorestaurante.Services.intf;

import com.example.modeloRestaurante.entidades.Adicionales;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceAdicionales {
    void agregarAdicionales(Adicionales adicionales) throws Exception;
    void actualizarAdicionales(Adicionales adicionales) throws Exception;
    void eliminarAdicionales(Long id);
    Adicionales obtenerAdicionales(Long id);
    List<Adicionales> obtenerTodasAdicionales();
    Adicionales obtenerAdicionalporNombre(String nombre);
}
