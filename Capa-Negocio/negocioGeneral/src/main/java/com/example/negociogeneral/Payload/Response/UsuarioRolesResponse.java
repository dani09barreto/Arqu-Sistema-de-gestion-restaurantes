package com.example.negociogeneral.Payload.Response;

import lombok.*;

import java.math.BigInteger;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UsuarioRolesResponse {
    private String username;
    private String nombre;
    private String email;
    private BigInteger telefono;
    private List <String> roles;
}
