package com.example.modeloGeneral.GestionDatos.intf;

import com.example.entidades.Menu;
import com.example.entidades.Plato;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface IPlatoService {
    Plato agregarPlato(Plato plato);
    void actualizarPlato(Plato plato);
    void eliminarPlato(Long id);
    Plato obtenerPlato(Long id);
    Plato obtenerPlatoPorNombre(String nombre);
    List <Plato> obtenerTodosPlatosPorMenu(Menu menu);
}
