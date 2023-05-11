package com.example.IRemoteServiciosDatos;

import com.example.entidades.Rol;
import com.example.entidades.RolUsuario;
import com.example.entidades.Usuario;
import jakarta.ejb.Remote;

import java.util.List;

@Remote
public interface IRemoteUsuarioService {
    Usuario agregarUsuario(Usuario usuario, List<Rol> roles);
    void actualizarUsuario(Usuario usuario);
    void eliminarUsuario(String username);
    Usuario obtenerUsuarioPorNombreUsuario(String nombreUsuario);
    List<RolUsuario> obtenerRolUsuarioPorNombreUsuario(String nombreUsuario);
}
