package com.example.envios_app.REST;

import com.example.envios_app.model.AuthToken;
import com.example.envios_app.model.LoginUser;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IUsuarioService {
    @POST("login")
    Call <AuthToken> login (@Body LoginUser loginUser);
}
