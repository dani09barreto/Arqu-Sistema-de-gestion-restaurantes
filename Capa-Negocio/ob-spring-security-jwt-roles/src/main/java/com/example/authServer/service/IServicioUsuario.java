package com.example.obspringsecurityjwtroles.service;


import com.example.entidades.Usuario;
import com.example.obspringsecurityjwtroles.payload.request.UsuarioRequest;

import javax.naming.NamingException;
import java.io.IOException;


public interface IServicioUsuario {
    void agregarUsuario(UsuarioRequest usuario) throws NamingException, IOException;
}
