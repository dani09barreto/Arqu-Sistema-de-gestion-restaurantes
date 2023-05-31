package com.example.envios_app.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.envios_app.R;
import com.example.envios_app.REST.IDespachadorService;
import com.example.envios_app.REST.IUsuarioService;
import com.example.envios_app.model.DestServer;
import com.example.envios_app.model.ServicesRoutes;
import com.example.envios_app.utils.ResponseLB;
import com.example.envios_app.databinding.ActivityLoginBinding;
import com.example.envios_app.model.AuthToken;
import com.example.envios_app.model.LoginUser;
import com.example.envios_app.utils.RetrofitClient;

import java.math.BigInteger;
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
    private IDespachadorService despachadorService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        if (!existeDestinoAuth()){
            getUrlDespachador();
        }

        binding.loginButton.setOnClickListener(view -> getUrlAuth());
        binding.singUpButton.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), SingUpActivity.class);
            startActivity(intent);
        });
    }

    private void getUrlDespachador() {
        responseLB.getResponse(ServicesRoutes.getUrlLbDespachador(), new ResponseLB.ResponseCallback() {
            @Override
            public void onResponse(String headerValue) {
                getUrlLBAuth(ServicesRoutes.getServerDespachador(headerValue));
            }

            @Override
            public void onError(String errorMessage) {
                alertsHelper.shortToast(getApplicationContext(), errorMessage);
            }
        });
    }

    private void getUrlLBAuth(String urlDespachador) {

        despachadorService = RetrofitClient.getRetrofitInstance(urlDespachador).create(IDespachadorService.class);

        Call<DestServer> call = despachadorService.obtenerDestino(ServicesRoutes.getDestinoAuth());
        call.enqueue(new Callback<DestServer>() {
            @Override
            public void onResponse(Call<DestServer> call, Response<DestServer> response) {
                if (response.isSuccessful()){
                    runOnUiThread(() -> {
                        DestServer destServer = response.body();
                        if (destServer != null) {
                            SharedPreferences sharedPref = getSharedPreferences("session_envio", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPref.edit();
                            editor.putString("direccionAuth", destServer.getDireccion());
                            editor.apply();
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<DestServer> call, Throwable t) {
                alertsHelper.shortToast(getApplicationContext(), t.getMessage());
            }
        });

    }

    private void getUrlAuth(){
        loadingDialog.show();
        responseLB.getResponse(getDestinoAuth(), new ResponseLB.ResponseCallback() {
            @Override
            public void onResponse(String headerValue) {
                doLogin(ServicesRoutes.getServerAuth(headerValue));
            }

            @Override
            public void onError(String errorMessage) {
                alertsHelper.shortToast(getApplicationContext(), errorMessage);
            }
        });
    }

    private void doLogin(String urlAuth) {
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

        userService = RetrofitClient.getRetrofitInstance(urlAuth).create(IUsuarioService.class);
        LoginUser loginUser = new LoginUser(user, pass);
        Call<AuthToken> call = userService.login(loginUser);
        call.enqueue(new Callback<AuthToken>() {
            @Override
            public void onResponse(Call<AuthToken> call, Response<AuthToken> response) {
                if (response.isSuccessful()){
                    runOnUiThread(() ->{
                        AuthToken token = response.body();
                        SharedPreferences sharedPreferences = getSharedPreferences("session_envio", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("token", token.getToken());
                        editor.putString("username", loginUser.getUsername());
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