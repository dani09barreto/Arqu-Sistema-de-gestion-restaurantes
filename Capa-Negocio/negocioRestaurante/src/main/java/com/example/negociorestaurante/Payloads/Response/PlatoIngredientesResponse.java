package com.example.negociorestaurante.Payloads.Response;

import com.example.entidades.Ingrediente;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class PlatoIngredientesResponse {
    private PlatoResponse plato;
    private List<Ingrediente> ingredientes = new ArrayList<>();
}
