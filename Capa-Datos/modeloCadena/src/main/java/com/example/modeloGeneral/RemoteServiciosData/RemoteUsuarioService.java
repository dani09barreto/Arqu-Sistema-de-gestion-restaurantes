package com.example.modeloGeneral.RemoteServiciosData;

import com.example.IRemoteServiciosDatos.IRemoteUsuarioService;
import com.example.entidades.Rol;
import com.example.entidades.RolUsuario;
import com.example.modeloGeneral.GestionDatos.intf.IRolUsuarioService;
import com.example.modeloGeneral.GestionDatos.intf.IUsuarioService;
import com.example.entidades.Usuario;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class RemoteUsuarioService implements IRemoteUsuarioService {

    @EJB
    IUsuarioService usuarioService;
    @EJB
    IRolUsuarioService rolUsuarioService;

    @Override
    public Usuario agregarUsuario(Usuario usuario, List<Rol> roles) {
        Usuario us = usuarioService.agregarUsuario(usuario);
        if (us ==  null){
            return null;
        }
        for (Rol rol : roles) {
            RolUsuario rolUsuario = RolUsuario.builder()
                    .usuario(us)
                    .rol(rol)
                    .build();
            rolUsuarioService.agregarRolUsuario(rolUsuario);
        }
        return us;
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
        Usuario us = usuarioService.obtenerUsuarioPorNombreUsuario(nombreUsuario);
        System.out.println(us);
        return us;
    }

    @Override
    public List<RolUsuario> obtenerRolUsuarioPorNombreUsuario(String nombreUsuario) {
        Usuario us = usuarioService.obtenerUsuarioPorNombreUsuario(nombreUsuario);
        return rolUsuarioService.obtenerRolesUsuario(us);
    }
}
