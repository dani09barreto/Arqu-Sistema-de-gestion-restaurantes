package com.example.authServer.payload.request;

import lombok.*;

import java.math.BigInteger;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@Builder
public class UsuarioRequest {
    private String usuario;
    private String password;
    private String nombre;
    private String correo;
    private BigInteger telefono;
    private String rol;
}
