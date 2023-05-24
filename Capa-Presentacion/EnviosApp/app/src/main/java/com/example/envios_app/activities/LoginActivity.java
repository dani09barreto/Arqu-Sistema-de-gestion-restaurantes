package com.example.envios_app.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.envios_app.R;
import com.example.envios_app.REST.IUsuarioService;
import com.example.envios_app.databinding.ActivityLoginBinding;
import com.example.envios_app.model.AuthToken;
import com.example.envios_app.model.LoginUser;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends BasicActivity {

    private ActivityLoginBinding binding;
    private IUsuarioService userService;
    private static final String BASE_URL = "http://192.168.10.13:8180/api/auth/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(120, TimeUnit.SECONDS) // Timeout para establecer la conexión
                .readTimeout(120, TimeUnit.SECONDS) // Timeout para leer la respuesta
                .writeTimeout(120, TimeUnit.SECONDS) // Timeout para escribir la solicitud
                .hostnameVerifier((hostname, session) -> true)
                .build();

        // Crear instancia de Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Crear objeto del servicio
        userService = retrofit.create(IUsuarioService.class);

        binding.loginButton.setOnClickListener(view -> doLogin());

    }

    private void doLogin() {
        loadingDialog.show();
        String user = Objects.requireNonNull(binding.loginUsername.getEditText()).getText().toString();
        String pass = Objects.requireNonNull(binding.loginPass.getEditText()).getText().toString();

        if (user.isEmpty()) {
            alertsHelper.shortSimpleSnackbar(binding.getRoot(), getString(R.string.mail_error_label));
            binding.loginUsername.setErrorEnabled(true);
            binding.loginUsername.setError(getString(R.string.mail_error_label));
            return;
        }

        if (pass.isEmpty()) {
            alertsHelper.shortSimpleSnackbar(binding.getRoot(), getString(R.string.error_pass_label));
            binding.loginPass.setErrorEnabled(true);
            binding.loginPass.setError(getString(R.string.error_pass_label));
            return;
        }
        LoginUser loginUser = new LoginUser(user, pass);
        Call<AuthToken> call = userService.login(loginUser);
        call.enqueue(new Callback<AuthToken>() {
            @Override
            public void onResponse(Call<AuthToken> call, Response<AuthToken> response) {
                if (response.isSuccessful()){
                    alertsHelper.shortToast(getApplicationContext(), "Usuario o contraseña no validos");
                    runOnUiThread(() ->{
                        AuthToken token = response.body();
                        SharedPreferences sharedPreferences = getSharedPreferences("session", Context.MODE_PRIVATE);
                        // Crea un objeto Editor para realizar modificaciones en SharedPreferences
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("token", token.getToken());
                        editor.apply();
                        loadingDialog.dismissDialog();
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    });
                }
                else{
                    alertsHelper.shortToast(getApplicationContext(), "Usuario o contraseña incorrectos");
                    loadingDialog.dismissDialog();
                }

            }

            @Override
            public void onFailure(Call<AuthToken> call, Throwable t) {
                alertsHelper.shortToast(getApplicationContext(), "Error al iniciar sesion intente de nuevo");
                loadingDialog.dismissDialog();
            }
        });


    }

    public static Intent createIntent(Activity activity) {
        return new Intent(activity, LoginActivity.class);
    }
}