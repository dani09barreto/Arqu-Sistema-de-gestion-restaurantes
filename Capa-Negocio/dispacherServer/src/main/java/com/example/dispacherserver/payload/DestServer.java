package com.example.dispacherserver.payload;

public class DestServer {
    private String direccion;

    public DestServer() {
    }

    public DestServer(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}


