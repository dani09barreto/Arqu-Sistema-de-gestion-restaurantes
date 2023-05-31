package com.example.rest_admin_app.REST;

import com.example.rest_admin_app.model.DestServer;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IDespachadorService {

    @GET("dest={destino}")
    Call<DestServer> obtenerDestino (@Path("destino") String destino);
}
