package com.example.negociorestaurante.Payloads.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlatoRequest {
    private long id;
    private Integer cantidad;
}
