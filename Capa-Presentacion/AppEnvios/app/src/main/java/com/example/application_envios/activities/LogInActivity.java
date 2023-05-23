package com.example.application_envios.activities;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.application_envios.R;
import com.example.application_envios.databinding.ActivityLogInBinding;
import com.example.application_envios.model.AuthToken;
import com.example.application_envios.model.LoginUser;
import com.example.application_envios.REST.IUsuarioService;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class LogInActivity extends BasicActivity {

    private ActivityLogInBinding binding;
    private IUsuarioService usuarioService;
    private static final String BASE_URL = "http://172.20.10.4:8180/api/auth/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLogInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .hostnameVerifier((hostname, session) -> true)
                .connectTimeout(120, TimeUnit.SECONDS) // Timeout para establecer la conexión
                .readTimeout(120, TimeUnit.SECONDS) // Timeout para leer la respuesta
                .writeTimeout(120, TimeUnit.SECONDS) // Timeout para escribir la solicitud
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        usuarioService = retrofit.create(IUsuarioService.class);

        binding.loginButton.setOnClickListener(view -> doLogin());
    }

    private void doLogin() {
        String email = Objects.requireNonNull(binding.loginEmail.getEditText()).getText().toString();
        String pass = Objects.requireNonNull(binding.loginPass.getEditText()).getText().toString();
        loadingDialog.show();

        if (email.isEmpty()) {
            alertsHelper.shortSimpleSnackbar(binding.getRoot(), getString(R.string.mail_error_label));
            binding.loginEmail.setErrorEnabled(true);
            binding.loginEmail.setError(getString(R.string.mail_error_label));
            return;
        }

        if (pass.isEmpty()) {
            alertsHelper.shortSimpleSnackbar(binding.getRoot(), getString(R.string.error_pass_label));
            binding.loginPass.setErrorEnabled(true);
            binding.loginPass.setError(getString(R.string.error_pass_label));
            return;
        }
        LoginUser user = new LoginUser(email, pass);
        Call<AuthToken> call = usuarioService.login(user);
        call.enqueue(new Callback<AuthToken>() {
            @Override
            public void onResponse(Call<AuthToken> call, Response<AuthToken> response) {
                if (response.isSuccessful()){
                    runOnUiThread(() -> {
                        SharedPreferences preferences = getSharedPreferences("session", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        AuthToken token = response.body();
                        editor.putString("token", token.getToken());
                        editor.apply();
                        loadingDialog.dismissDialog();
                        startActivity(new Intent(LogInActivity.this, MainActivity.class));
                    });
                }else{
                    alertsHelper.shortToast(getApplicationContext(), "Usuario o Contraseña incorrectos");
                    loadingDialog.dismissDialog();
                }
            }

            @Override
            public void onFailure(Call<AuthToken> call, Throwable t) {
                alertsHelper.shortSimpleSnackbar(binding.getRoot(), t.getMessage());
                loadingDialog.dismissDialog();
            }
        });
    }

    public static Intent createIntent(Activity activity) {
        return new Intent(activity, LogInActivity.class);
    }
}