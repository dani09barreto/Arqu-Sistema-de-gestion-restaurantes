package com.example.rest_admin_app.activites;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.example.rest_admin_app.activites.dialog.LoadingDialog;
import com.example.rest_admin_app.services.LocationService;
import com.example.rest_admin_app.services.RouterGoogleAPIService;
import com.example.rest_admin_app.utils.AlertsHelper;
import com.example.rest_admin_app.utils.PermissionHelper;
import com.example.rest_admin_app.utils.ResponseLB;

import javax.inject.Inject;

public abstract class BasicActivity extends AppCompatActivity {
    protected SharedPreferences sharedPreferences;
    protected LoadingDialog loadingDialog;
    @Inject
    AlertsHelper alertsHelper;
    @Inject
    PermissionHelper permissionHelper;
    @Inject
    LocationService locationService;
    @Inject
    RouterGoogleAPIService routerGoogleAPIService;
    @Inject
    ResponseLB responseLB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ((App) getApplicationContext()).getAppComponent().inject(this);
        super.onCreate(savedInstanceState);
        loadingDialog = new LoadingDialog(this);
    }

    protected boolean existeDestinoAuth(){
        sharedPreferences = getSharedPreferences("session_rest", Context.MODE_PRIVATE);
        return sharedPreferences.getString("direccionAuth", null) != null;
    }

    protected String getDestinoAuth(){
        sharedPreferences = getSharedPreferences("session_rest", Context.MODE_PRIVATE);
        return sharedPreferences.getString("direccionAuth", null);
    }
}
