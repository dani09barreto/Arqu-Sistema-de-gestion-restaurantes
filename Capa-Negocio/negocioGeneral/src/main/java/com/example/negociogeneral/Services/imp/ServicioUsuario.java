package com.example.negociogeneral.Services.imp;

import com.example.entidades.RolUsuario;
import com.example.entidades.Usuario;
import com.example.negociogeneral.Payload.Response.UsuarioRolesResponse;
import com.example.negociogeneral.ServiceLocator.IServiceLocator;
import com.example.negociogeneral.Services.intf.IServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import java.io.IOException;
import java.util.List;

@Service
public class ServicioUsuario implements IServicioUsuario {

    @Autowired
    @Qualifier("serviceLocator")
    private IServiceLocator serviceLocator;

    @Override
    public Usuario obtenerUsuario(String username, String uri) throws NamingException, IOException {
        return serviceLocator.getRemoteUsuarioService(uri).obtenerUsuarioPorNombreUsuario(username);
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario, String uri) throws NamingException, IOException {
        serviceLocator.getRemoteUsuarioService(uri).actualizarUsuario(usuario);
        return serviceLocator.getRemoteUsuarioService(uri).obtenerUsuarioPorNombreUsuario(usuario.getUsuario());
    }

    @Override
    public void EliminarUsuario(String username, String uri) throws NamingException, IOException {
        serviceLocator.getRemoteUsuarioService(uri).eliminarUsuario(username);
    }

    @Override
    public UsuarioRolesResponse obtenerUsuarioRoles(String username, String uri) throws NamingException, IOException {
        List <RolUsuario> roles = serviceLocator.getRemoteUsuarioService(uri).obtenerRolUsuarioPorNombreUsuario(username);
        Usuario us = roles.get(0).getUsuario();
        return UsuarioRolesResponse.builder()
                .nombre(us.getNombre())
                .email(us.getCorreo())
                .telefono(us.getTelefono())
                .username(us.getUsuario())
                .roles(roles.stream().map(rolUsuario -> rolUsuario.getRol().getNombre()).toList()).build();
    }
}
