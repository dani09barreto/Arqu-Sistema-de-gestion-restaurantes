package com.example.negociorestaurante.Payloads.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class PedidoResponse {
    private List<PlatoIngredientesResponse> lista_plato;
    private long idPedido;
}
