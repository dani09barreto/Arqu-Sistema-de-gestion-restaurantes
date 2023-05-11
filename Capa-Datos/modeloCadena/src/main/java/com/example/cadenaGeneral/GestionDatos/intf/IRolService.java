package com.example.cadenaGeneral.GestionDatos.intf;

import com.example.entidades.Rol;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface IRolService {
    void agregarRol(Rol rol);
    void actualizarRol(Rol rol);
    void eliminarRol(Long id);
    Rol obtenerRol(Long id);
    Rol obtenerRolPorNombre(String nombre);
    List<Rol> obtenerTodosRoles();
}
