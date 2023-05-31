package com.example.rest_admin_app.model;

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

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double latitude) {
        this.lat = latitude;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double longitude) {
        this.lng = longitude;
    }
}
