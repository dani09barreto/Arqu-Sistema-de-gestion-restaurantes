package com.example.negociogeneral.Services.intf;

import com.example.entidades.Usuario;
import com.example.negociogeneral.Payload.Response.UsuarioRolesResponse;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import java.io.IOException;

@Service
public interface IServicioUsuario {
    Usuario obtenerUsuario(String username) throws NamingException, IOException;
    Usuario actualizarUsuario(Usuario usuario) throws NamingException, IOException;
    void EliminarUsuario(String username) throws NamingException, IOException;
    UsuarioRolesResponse obtenerUsuarioRoles(String username) throws NamingException, IOException;
}
