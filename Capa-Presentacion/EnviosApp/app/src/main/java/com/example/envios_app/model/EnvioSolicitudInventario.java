package com.example.envios_app.model;


import java.io.Serializable;

public class EnvioSolicitudInventario implements Serializable {
    private EnvioInventario envioInventario;
    private String uriSocket;

    public EnvioSolicitudInventario(EnvioInventario envioInventario, String uriSocket) {
        this.envioInventario = envioInventario;
        this.uriSocket = uriSocket;
    }

    public EnvioInventario getEnvioInventario() {
        return envioInventario;
    }

    public void setEnvioInventario(EnvioInventario envioInventario) {
        this.envioInventario = envioInventario;
    }

    public String getUriSocket() {
        return uriSocket;
    }

    public void setUriSocket(String uriSocket) {
        this.uriSocket = uriSocket;
    }
}
