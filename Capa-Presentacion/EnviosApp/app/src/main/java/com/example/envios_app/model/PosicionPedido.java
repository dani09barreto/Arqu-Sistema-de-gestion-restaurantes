package com.example.envios_app.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor

public class PosicionPedido {

    private EnvioInventario envioInventario;
    private double lat;
    private double lng;

    public PosicionPedido(EnvioInventario envioInventario, double latitude, double longitude) {
        this.envioInventario = envioInventario;
        this.lat = latitude;
        this.lng = longitude;
    }
}
