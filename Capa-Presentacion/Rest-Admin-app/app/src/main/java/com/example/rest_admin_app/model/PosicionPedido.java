package com.example.rest_admin_app.model;

import lombok.NoArgsConstructor;


@NoArgsConstructor

public class PosicionPedido {
    private Long idPedido;
    private double lat;
    private double lng;

    public PosicionPedido(Long id, double latitude, double longitude) {
        this.idPedido = id;
        this.lat = latitude;
        this.lng = longitude;
    }
}
