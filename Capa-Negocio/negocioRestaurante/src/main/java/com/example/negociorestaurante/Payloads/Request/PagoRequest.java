package com.example.negociorestaurante.Payloads.Request;


import com.example.modeloRestaurante.entidades.Pedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PagoRequest {
    private Double valor;
    private String tipoPago;
    private Pedido pedido;
    private List<String> adiciones;
}
