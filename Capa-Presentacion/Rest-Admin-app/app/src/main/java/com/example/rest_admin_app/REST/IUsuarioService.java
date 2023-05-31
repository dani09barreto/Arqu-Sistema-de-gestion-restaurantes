package com.example.rest_admin_app.REST;

import com.example.rest_admin_app.model.AuthToken;
import com.example.rest_admin_app.model.LoginUser;
import com.example.rest_admin_app.model.Mensaje;
import com.example.rest_admin_app.model.Usuario;
import com.example.rest_admin_app.model.UsuarioRequest;
import com.example.rest_admin_app.model.UsuarioUpdate;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IUsuarioService {
    @POST("login")
    Call <AuthToken> login (@Body LoginUser loginUser);
    @POST("singUp")
    Call <Mensaje> singUp (@Body UsuarioRequest usuario);
    @GET("usuarios/usuario={username}")
    Call<Usuario> getUser(@Path("username") String username);
    @PUT("usuarios/actualizar")
    Call <Mensaje> updateUser(@Body UsuarioUpdate usuario);
}
