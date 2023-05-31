package com.example.rest_admin_app.activites;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.rest_admin_app.R;
import com.example.rest_admin_app.REST.IDespachadorService;
import com.example.rest_admin_app.model.DestServer;
import com.example.rest_admin_app.model.ServicesRoutes;
import com.example.rest_admin_app.utils.ResponseLB;
import com.example.rest_admin_app.utils.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AuthenticatedActivity extends BasicActivity{

    protected IDespachadorService despachadorService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public String getIdPedido(){
        sharedPreferences = getSharedPreferences("session_rest", Context.MODE_PRIVATE);
        String idPedido = sharedPreferences.getString("id_pedido", null);
        return idPedido;
    }
    protected String getIdRestaurante(){
        sharedPreferences = getSharedPreferences("session_rest", Context.MODE_PRIVATE);
        String idRestaurante = sharedPreferences.getString("idRestaurante", null);
        return idRestaurante;
    }

    protected boolean existeDestinoRestaurante(){
        sharedPreferences = getSharedPreferences("session_rest", Context.MODE_PRIVATE);
        return sharedPreferences.getString("direccionRestaurante", null) != null;
    }
    protected String getDestinoRestaurante(){
        sharedPreferences = getSharedPreferences("session_rest", Context.MODE_PRIVATE);
        return sharedPreferences.getString("direccionRestaurante", null);
    }
    protected boolean existePathRestaurante(){
        sharedPreferences = getSharedPreferences("session_rest", Context.MODE_PRIVATE);
        return sharedPreferences.getString("restaurante", null) != null;
    }

    protected String getPathRestaurante(){
        sharedPreferences = getSharedPreferences("session_rest", Context.MODE_PRIVATE);
        return sharedPreferences.getString("restaurante", null);
    }

    protected boolean isAuthenticated() {
        sharedPreferences = getSharedPreferences("session_rest", Context.MODE_PRIVATE);
        return sharedPreferences.getString("token", null) != null;
    }

    protected boolean existeDestinoGeneral(){
        sharedPreferences = getSharedPreferences("session_rest", Context.MODE_PRIVATE);
        return sharedPreferences.getString("direccionGeneral", null) != null;
    }

    protected String getDestinoGeneral(){
        sharedPreferences = getSharedPreferences("session_rest", Context.MODE_PRIVATE);
        return sharedPreferences.getString("direccionGeneral", null);
    }

    protected String getTokenUser(){
        sharedPreferences = getSharedPreferences("session_rest", Context.MODE_PRIVATE);
        return sharedPreferences.getString("token", null);
    }

    protected String getUsername(){
        sharedPreferences = getSharedPreferences("session_rest", Context.MODE_PRIVATE);
        return sharedPreferences.getString("username", null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!isAuthenticated()) {
            startActivity(LoginActivity.createIntent(this));
        }
    }


    public void signOut(){
        sharedPreferences = getSharedPreferences("session_rest", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        startActivity(LoginActivity.createIntent(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.logoutButton){
            signOut();
        }
        else if (item.getItemId() == R.id.userInfo){
            if (!existeDestinoGeneral()){
                alertsHelper.shortToast(getApplicationContext(), "Debes realizar primero la conexion");
            }
            else {
                infoUser();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void infoUser() {
        startActivity(UserActivity.createIntent(this));
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
                            SharedPreferences sharedPref = getSharedPreferences("session_rest", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPref.edit();
                            editor.putString("direccionGeneral", destServer.getDireccion());
                            editor.apply();
                        }
                        MainActivity mainActivity = (MainActivity) AuthenticatedActivity.this;
                        mainActivity.getUrlGeneral();
                    });
                }
            }

            @Override
            public void onFailure(Call<DestServer> call, Throwable t) {
                alertsHelper.shortToast(getApplicationContext(), t.getMessage());
            }
        });
    }
}
