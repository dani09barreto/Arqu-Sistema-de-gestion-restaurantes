package com.example.negociorestaurante.Payloads.Request;

<<<<<<< HEAD
import com.example.entidades.Cliente;
=======

import com.example.modeloRestaurante.entidades.Cliente;
>>>>>>> develop
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PedidoRequest {
    private Long mesaId;
    private Cliente cliente;
    private List <PlatoRequest> platos;
}
