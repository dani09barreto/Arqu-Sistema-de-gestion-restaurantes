package com.example.modeloGeneral.GestionDatos.intf;

import com.example.entidades.Usuario;
import jakarta.ejb.Local;

@Local
public interface IUsuarioService {
    Usuario agregarUsuario(Usuario usuario);
    void actualizarUsuario(Usuario usuario);
    void eliminarUsuario(String username);
    Usuario obtenerUsuarioPorNombreUsuario(String nombreUsuario);
}
