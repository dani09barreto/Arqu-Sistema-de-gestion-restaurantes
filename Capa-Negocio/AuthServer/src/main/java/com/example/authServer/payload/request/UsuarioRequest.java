package com.example.authServer.payload.request;

import lombok.*;

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
    private Double telefono;
    private String rol;
}
