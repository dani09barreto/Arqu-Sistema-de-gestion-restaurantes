package com.example.rest_admin_app.model;

import java.io.Serializable;
import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements Serializable {
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
