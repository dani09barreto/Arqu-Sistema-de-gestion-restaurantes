package com.example.negociogeneral.Payload.Response;

import com.example.entidades.Ingrediente;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class InventarioIngredienteResponse {
    private Ingrediente ingrediente;
    private Integer cantidad;
}
