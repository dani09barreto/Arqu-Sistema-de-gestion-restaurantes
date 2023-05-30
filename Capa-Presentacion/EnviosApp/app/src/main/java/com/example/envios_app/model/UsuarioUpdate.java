package com.example.envios_app.model;

import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioUpdate {
    private String usuario;
    private String nombre;
    private String correo;
    private BigInteger telefono;
}
