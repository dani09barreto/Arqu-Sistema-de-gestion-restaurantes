package com.example.rest_admin_app.model;

import java.math.BigInteger;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder

public class UsuarioRequest {
    private String usuario;
    private String password;
    private String nombre;
    private String correo;
    private BigInteger telefono;
    private String rol;

    public UsuarioRequest(String usuario, String password, String nombre, String correo, BigInteger telefono, String rol) {
        this.usuario = usuario;
        this.password = password;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.rol = rol;
    }
}
