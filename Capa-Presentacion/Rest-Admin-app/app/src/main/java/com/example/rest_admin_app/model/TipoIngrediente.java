package com.example.rest_admin_app.model;

public class TipoIngrediente {
    private long id;
    private String nombre;

    public TipoIngrediente(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

}
