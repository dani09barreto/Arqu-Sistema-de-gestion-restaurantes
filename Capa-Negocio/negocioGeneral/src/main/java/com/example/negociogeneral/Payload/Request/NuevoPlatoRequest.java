package com.example.negociogeneral.Payload.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NuevoPlatoRequest {
    private String nombre;
    private String descripcion;
    private BigInteger precio;
    private String imagen;
    private List<IngredienteRequest> ingredientes;
}
