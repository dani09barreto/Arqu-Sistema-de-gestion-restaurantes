package com.example.rest_admin_app.model;

public class Ingrediente {
    private long id;
    private String nombre;
    private TipoIngrediente tipoIngredienteid;

    public Ingrediente(long id, String nombre, TipoIngrediente tipoIngredienteid) {
        this.id = id;
        this.nombre = nombre;
        this.tipoIngredienteid = tipoIngredienteid;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoIngrediente getTipoIngredienteid() {
        return tipoIngredienteid;
    }
}
