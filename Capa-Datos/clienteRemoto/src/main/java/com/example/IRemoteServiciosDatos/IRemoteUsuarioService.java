package com.example.IRemoteServiciosDatos;

import com.example.entidades.Usuario;
import jakarta.ejb.Remote;

@Remote
public interface IRemoteUsuarioService {
    Usuario agregarUsuario(Usuario usuario);
    void actualizarUsuario(Usuario usuario);
    void eliminarUsuario(String username);
    Usuario obtenerUsuarioPorNombreUsuario(String nombreUsuario);
}
