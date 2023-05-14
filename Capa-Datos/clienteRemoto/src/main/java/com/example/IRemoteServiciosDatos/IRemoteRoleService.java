package com.example.IRemoteServiciosDatos;

import com.example.entidades.Rol;
import jakarta.ejb.Remote;

import java.util.List;

@Remote
public interface IRemoteRoleService {
    void agregarRol(Rol rol);
    void actualizarRol(Rol rol);
    void eliminarRol(Long id);
    Rol obtenerRol(Long id);
    Rol obtenerRolPorNombre(String nombre);
    List <Rol> obtenerTodosRoles();
}
