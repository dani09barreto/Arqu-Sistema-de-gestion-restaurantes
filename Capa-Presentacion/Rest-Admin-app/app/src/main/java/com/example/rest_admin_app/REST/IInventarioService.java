package com.example.rest_admin_app.REST;

import com.example.rest_admin_app.model.Ingrediente;
import com.example.rest_admin_app.model.Inventario;
import com.example.rest_admin_app.model.Mensaje;
import com.example.rest_admin_app.model.SolicitudInventario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IInventarioService {
    @PUT("inventario/cambiarEstado/solicitud={idEnvio}&estado={nameEstado}")
    Call <Mensaje> cambiarEstado(@Path("idEnvio") Long idEnvio, @Path("nameEstado") String nameEstado);

    @GET("inventario/listAll")
    Call <List<Inventario>> listarInventario();

    @POST("inventario/solicitarInventario/restaurante={id}")
    Call <Mensaje> solicitarInventario(@Path("id") Long id, @Body SolicitudInventario solicitudInventario);

}
