package com.example.cadenaGeneral.RemoteServiciosData;

import com.example.IRemoteServiciosDatos.IRemoteUsuarioService;
import com.example.cadenaGeneral.GestionDatos.intf.IUsuarioService;
import com.example.entidades.Usuario;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class RemoteUsuarioService implements IRemoteUsuarioService {

    @EJB
    IUsuarioService usuarioService;

    @Override
    public Usuario agregarUsuario(Usuario usuario) {
        return usuarioService.agregarUsuario(usuario);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        usuarioService.actualizarUsuario(usuario);
    }

    @Override
    public void eliminarUsuario(String username) {
        usuarioService.eliminarUsuario(username);
    }

    @Override
    public Usuario obtenerUsuarioPorNombreUsuario(String nombreUsuario) {
        return usuarioService.obtenerUsuarioPorNombreUsuario(nombreUsuario);
    }
}
