package com.example.rest_admin_app.REST;

import com.example.rest_admin_app.model.Restaurante;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IRestaurantesServices {
    @GET("restaurantes/listar")
    Call <List<Restaurante>> listarRestaurantes();
}
