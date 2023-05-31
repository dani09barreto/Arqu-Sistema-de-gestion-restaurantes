package com.example.rest_admin_app.model;



public class Inventario {
    private long id;
    private Ingrediente ingredienteid;
    private int cantidad;

    public Inventario(long id, Ingrediente ingrediente, int cantidad) {
        this.id = id;
        this.ingredienteid = ingrediente;
        this.cantidad = cantidad;
    }

    public long getId() {
        return id;
    }

    public Ingrediente getIngrediente() {
        return ingredienteid;
    }

    public int getCantidad() {
        return cantidad;
    }



}
