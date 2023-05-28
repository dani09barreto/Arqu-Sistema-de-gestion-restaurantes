package com.example.envios_app.model;

import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    private Long id;
    private String usuario;
    private String password;
    private String nombre;
    private String correo;
    private BigInteger telefono;

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public BigInteger getTelefono() {
        return telefono;
    }
}
