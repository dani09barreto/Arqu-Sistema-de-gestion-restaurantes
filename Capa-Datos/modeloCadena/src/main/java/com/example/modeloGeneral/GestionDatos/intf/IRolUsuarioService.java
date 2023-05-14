package com.example.modeloGeneral.GestionDatos.intf;

import com.example.entidades.RolUsuario;
import com.example.entidades.Usuario;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface IRolUsuarioService {
    void agregarRolUsuario(RolUsuario rolUsuario);
    void eliminarRolUsuario(RolUsuario rolUsuario);
    List <RolUsuario> obtenerRolesUsuario(Usuario usuario);
}
