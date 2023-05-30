package com.example.negociorestaurante.Utils;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DistanciaHeap implements Comparable <DistanciaHeap>{
    private Long bodegaId;
    private int distancia;

    @Override
    public int compareTo(DistanciaHeap o) {
        return Integer.compare(this.distancia, o.distancia);
    }
}
