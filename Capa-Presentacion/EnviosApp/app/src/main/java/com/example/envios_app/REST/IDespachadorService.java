package com.example.envios_app.REST;

import com.example.envios_app.model.DestServer;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IDespachadorService {

    @GET("dest={destino}")
    Call<DestServer> obtenerDestino (@Path("destino") String destino);
}
