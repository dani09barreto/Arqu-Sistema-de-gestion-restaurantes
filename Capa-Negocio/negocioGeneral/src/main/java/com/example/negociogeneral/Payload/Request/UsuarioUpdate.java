package com.example.negociogeneral.Payload.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

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
