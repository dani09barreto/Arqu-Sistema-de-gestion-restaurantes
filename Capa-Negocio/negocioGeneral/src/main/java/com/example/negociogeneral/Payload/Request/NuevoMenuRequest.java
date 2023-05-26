package com.example.negociogeneral.Payload.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NuevoMenuRequest {
    private String nombre;
    private List <NuevoPlatoRequest> platos;
}
