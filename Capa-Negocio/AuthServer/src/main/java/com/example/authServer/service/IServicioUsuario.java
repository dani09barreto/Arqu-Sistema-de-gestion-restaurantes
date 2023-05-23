package com.example.authServer.service;


import com.example.authServer.payload.request.UsuarioRequest;
import com.example.entidades.Usuario;

import javax.naming.NamingException;
import java.io.IOException;


public interface IServicioUsuario {
    Boolean agregarUsuario(UsuarioRequest usuario) throws NamingException, IOException;
}
