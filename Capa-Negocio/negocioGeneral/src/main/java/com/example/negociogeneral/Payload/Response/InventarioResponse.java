package com.example.negociogeneral.Payload.Response;

import com.example.entidades.Bodega;
import com.example.entidades.Ingrediente;
import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class InventarioResponse {
    private Bodega bodega;
    private List <InventarioIngredienteResponse> ingredientes;
}
