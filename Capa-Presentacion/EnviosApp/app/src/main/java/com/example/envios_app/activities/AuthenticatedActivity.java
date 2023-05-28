package com.example.envios_app.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.envios_app.R;
import com.example.envios_app.REST.IDespachadorService;
import com.example.envios_app.model.DestServer;
import com.example.envios_app.model.ServicesRoutes;
import com.example.envios_app.utils.ResponseLB;
import com.example.envios_app.utils.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AuthenticatedActivity extends BasicActivity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    protected boolean isAuthenticated() {
        sharedPreferences = getSharedPreferences("session", Context.MODE_PRIVATE);
        return sharedPreferences.getString("token", null) != null;
    }

    protected boolean existeDestinoGeneral(){
        sharedPreferences = getSharedPreferences("session", Context.MODE_PRIVATE);
        return sharedPreferences.getString("direccionGeneral", null) != null;
    }

    protected String getDestinoGeneral(){
        sharedPreferences = getSharedPreferences("session", Context.MODE_PRIVATE);
        return sharedPreferences.getString("direccionGeneral", null);
    }

    protected String getTokenUser(){
        sharedPreferences = getSharedPreferences("session", Context.MODE_PRIVATE);
        return sharedPreferences.getString("token", null);
    }

    protected String getUsername(){
        sharedPreferences = getSharedPreferences("session", Context.MODE_PRIVATE);
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
        sharedPreferences = getSharedPreferences("session", Context.MODE_PRIVATE);
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
        switch(item.getItemId()){
            case R.id.logoutButton:
                signOut();
                break;
            case R.id.userInfo:
                if (!existeDestinoGeneral()){
                    alertsHelper.shortToast(getApplicationContext(), "Debes realizar primero la conexion");
                }
                else {
                    infoUser();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void infoUser() {
        startActivity(UserActivity.createIntent(this));
    }
}
