package com.example.envios_app.utils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public static Retrofit getRetrofitInstance(String BASE_URL) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(120, TimeUnit.SECONDS) // Timeout para establecer la conexión
                .readTimeout(120, TimeUnit.SECONDS) // Timeout para leer la respuesta
                .writeTimeout(120, TimeUnit.SECONDS) // Timeout para escribir la solicitud
                .hostnameVerifier((hostname, session) -> true)
                .build();

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}

