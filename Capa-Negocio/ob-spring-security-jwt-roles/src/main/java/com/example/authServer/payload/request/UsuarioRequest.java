package com.example.obspringsecurityjwtroles.payload.request;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

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
