package com.example.negociogeneral.Payload.Request;

import com.example.entidades.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InventarioRequest {
    private String uri;
    private Long ingredienteId;
    private int cantidad;
}
