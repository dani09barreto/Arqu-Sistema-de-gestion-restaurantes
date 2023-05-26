package com.example.negociogeneral.Payload.Response;

import lombok.*;

import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PlatoResponse {
    private Long id;
    private String nombre;
    private String descripcion;
    private BigInteger precio;
    private String imagen;
}
