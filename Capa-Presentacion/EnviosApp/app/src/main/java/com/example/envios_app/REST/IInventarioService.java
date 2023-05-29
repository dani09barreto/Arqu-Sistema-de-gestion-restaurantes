package com.example.envios_app.REST;

import com.example.envios_app.model.Mensaje;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IInventarioService {
    @PUT("inventario/cambiarEstado/solicitud={idEnvio}&estado={nameEstado}")
    Call <Mensaje> cambiarEstado(@Path("idEnvio") Long idEnvio, @Path("nameEstado") String nameEstado);
}
