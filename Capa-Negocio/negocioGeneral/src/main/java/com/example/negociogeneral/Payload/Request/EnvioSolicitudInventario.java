package com.example.negociogeneral.Payload.Request;

import com.example.entidades.EnvioInventario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnvioSolicitudInventario {
    private EnvioInventario envioInventario;
    private String uriSocket;
}
