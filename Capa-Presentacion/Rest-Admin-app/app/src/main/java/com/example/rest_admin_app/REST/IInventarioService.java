package com.example.rest_admin_app.REST;

import com.example.rest_admin_app.model.Mensaje;

import retrofit2.Call;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IInventarioService {
    @PUT("inventario/cambiarEstado/solicitud={idEnvio}&estado={nameEstado}")
    Call <Mensaje> cambiarEstado(@Path("idEnvio") Long idEnvio, @Path("nameEstado") String nameEstado);
}
