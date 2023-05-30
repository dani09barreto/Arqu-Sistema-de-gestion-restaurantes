package com.example.negociorestaurante.Payloads.Request;

<<<<<<< HEAD
import com.example.entidades.Pedido;
=======

import com.example.modeloRestaurante.entidades.Pedido;
>>>>>>> develop
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PagoRequest {
    private Double valor;
    private String tipoPago;
    private Double descuento;
    private Pedido pedido;
}
