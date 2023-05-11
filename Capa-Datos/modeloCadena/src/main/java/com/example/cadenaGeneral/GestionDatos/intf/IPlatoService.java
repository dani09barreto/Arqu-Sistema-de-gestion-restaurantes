package com.example.cadenaGeneral.GestionDatos.intf;

import com.example.entidades.Menu;
import com.example.entidades.Plato;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface IPlatoService {
    void agregarPlato(Plato plato);
    void actualizarPlato(Plato plato);
    void eliminarPlato(Long id);
    Plato obtenerPlato(Long id);
    List <Plato> obtenerTodosPlatosPorMenu(Menu menu);
}
