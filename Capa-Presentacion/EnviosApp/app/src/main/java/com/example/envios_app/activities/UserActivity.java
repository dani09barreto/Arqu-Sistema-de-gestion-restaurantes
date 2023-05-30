package com.example.envios_app.activities;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CompoundButton;

import com.example.envios_app.REST.IDespachadorService;
import com.example.envios_app.REST.IUsuarioService;
import com.example.envios_app.databinding.ActivityUserBinding;
import com.example.envios_app.model.DestServer;
import com.example.envios_app.model.ServicesRoutes;
import com.example.envios_app.model.Usuario;
import com.example.envios_app.model.UsuarioUpdate;
import com.example.envios_app.utils.ResponseLB;
import com.example.envios_app.utils.RetrofitClient;
import com.google.gson.JsonObject;

import java.math.BigInteger;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserActivity extends AuthenticatedActivity {

    private ActivityUserBinding binding;
    private IUsuarioService usuarioService;
    private IDespachadorService despachadorService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        getUrlGeneral();

        binding.switchEditar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    binding.userName.setEnabled(true);
                    binding.userEmail.setEnabled(true);
                    binding.userPhone.setEnabled(true);
                    binding.btnSave.setEnabled(true);
                }
                else {
                    binding.userName.setEnabled(false);
                    binding.userEmail.setEnabled(false);
                    binding.userPhone.setEnabled(false);
                    binding.btnSave.setEnabled(false);
                }
            }
        });

        binding.backBtn.setOnClickListener(v -> {
            finish();
        });

        binding.btnSave.setOnClickListener(v -> {
            loadingDialog.show();
            String username = getUsername();
            String name = binding.userName.getEditText().getText().toString();
            String email = binding.userEmail.getEditText().getText().toString();
            BigInteger phone = new BigInteger(binding.userPhone.getEditText().getText().toString());
            UsuarioUpdate usuarioUpdate = new UsuarioUpdate(username, name, email, phone);

            Call<JsonObject> call = usuarioService.updateUser(usuarioUpdate);
            call.enqueue(new Callback<JsonObject>() {
                @Override
                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                    if (!response.isSuccessful()){
                        alertsHelper.shortToast(getApplicationContext(), "Error al actualizar la información del usuario");
                        return;
                    }
                    alertsHelper.shortToast(getApplicationContext(), "Información actualizada");
                    loadingDialog.dismiss();
                }

                @Override
                public void onFailure(Call<JsonObject> call, Throwable t) {
                    alertsHelper.shortToast(getApplicationContext(), "Error al conectar con el servidor");
                    loadingDialog.dismiss();
                }
            });
        });

    }

    private void getUrlGeneral(){
        responseLB.getResponse(getDestinoGeneral(), new ResponseLB.ResponseCallback() {
            @Override
            public void onResponse(String headerValue) {
                getInfoUser(headerValue);
            }

            @Override
            public void onError(String errorMessage) {

            }
        });
    }

    private void getInfoUser(String ipGeneral){
        loadingDialog.show();
        String token = getTokenUser();
        String username = getUsername();
        this.usuarioService = RetrofitClient.getRetrofitInstance(ServicesRoutes.getServerGeneral(ipGeneral), token).create(IUsuarioService.class);
        Call<Usuario> call = usuarioService.getUser(username);

        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if (!response.isSuccessful()){
                    if (response.code() == 401){
                        alertsHelper.shortToast(getApplicationContext(), "Se ha vencido la sesión");
                        signOut();
                        return;
                    }
                    alertsHelper.shortToast(getApplicationContext(), "Error al obtener la información del usuario");
                    return;
                }
                Usuario usuario = response.body();
                Objects.requireNonNull(binding.userName.getEditText()).setText(usuario.getNombre());
                Objects.requireNonNull(binding.userEmail.getEditText()).setText(usuario.getCorreo());
                Objects.requireNonNull(binding.userPhone.getEditText()).setText(String.valueOf(usuario.getTelefono()));
                loadingDialog.dismissDialog();
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                alertsHelper.shortToast(getApplicationContext(), "Error al conectar con el servidor");
                loadingDialog.dismissDialog();
            }
        });

    }


    protected void getUrlDespachador() {
        responseLB.getResponse(ServicesRoutes.getUrlLbDespachador(), new ResponseLB.ResponseCallback() {
            @Override
            public void onResponse(String headerValue) {
                getUrlLBGeneal(ServicesRoutes.getServerDespachador(headerValue));
            }

            @Override
            public void onError(String errorMessage) {
                alertsHelper.shortToast(getApplicationContext(), errorMessage);
            }
        });
    }


    protected void getUrlLBGeneal(String serverDespachador) {
        despachadorService = RetrofitClient.getRetrofitInstance(serverDespachador).create(IDespachadorService.class);

        Call<DestServer> call = despachadorService.obtenerDestino(ServicesRoutes.getDestinoGeneral());
        call.enqueue(new Callback<DestServer>() {
            @Override
            public void onResponse(Call<DestServer> call, Response<DestServer> response) {
                if (response.isSuccessful()){
                    runOnUiThread(() -> {
                        DestServer destServer = response.body();
                        if (destServer != null) {
                            SharedPreferences sharedPref = getSharedPreferences("session", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPref.edit();
                            editor.putString("direccionGeneral", destServer.getDireccion());
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

    public static Intent createIntent(Activity activity) {
        return new Intent(activity, UserActivity.class);
    }
}