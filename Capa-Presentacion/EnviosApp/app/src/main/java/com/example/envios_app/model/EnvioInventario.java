package com.example.envios_app.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class EnvioInventario {
    private Long id;
    private Restaurante restaurante;
    private Usuario usuario;
    private EstadoEnvio estadoEnvio;
    private Bodega bodega;
    private Date fecha;

    public Long getId() {
        return id;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public EstadoEnvio getEstadoEnvio() {
        return estadoEnvio;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setEstadoEnvio(EstadoEnvio estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
