package com.example.negociogeneral.Payload.Response;

import com.example.entidades.Plato;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MenuResponse {
    private Long id;
    private String nombre;
    private List<PlatoResponse> platos;
}
