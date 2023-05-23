package com.example.application_envios.REST;

import com.example.application_envios.model.AuthToken;
import com.example.application_envios.model.LoginUser;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IUsuarioService {
    @POST("login")
    Call<AuthToken> login(@Body LoginUser loginUser);
}
