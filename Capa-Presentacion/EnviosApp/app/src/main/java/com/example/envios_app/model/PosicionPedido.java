package com.example.envios_app.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor

public class PosicionPedido {
    private Long idPedido;
    private double lat;
    private double lng;

    public PosicionPedido(Long idPedido, double latitude, double longitude) {
        this.idPedido = idPedido;
        this.lat = latitude;
        this.lng = longitude;
    }
}
