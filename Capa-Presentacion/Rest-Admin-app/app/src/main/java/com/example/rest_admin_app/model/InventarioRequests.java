package com.example.rest_admin_app.model;


import java.io.Serializable;

public class InventarioRequests implements Serializable {
    private Long ingredienteId;
    private int cantidad;


    public InventarioRequests(Long ingredienteId, int cantidad) {
        this.ingredienteId = ingredienteId;
        this.cantidad = cantidad;
    }

    public Long getIngredienteId() {
        return ingredienteId;
    }

    public void setIngredienteId(Long ingredienteId) {
        this.ingredienteId = ingredienteId;
    }


    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
