package com.example.application_envios.activities;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.application_envios.App;
import com.example.application_envios.activities.dialogs.LoadingDialog;
import com.example.application_envios.services.LocationService;
import com.example.application_envios.services.RouterGoogleAPIService;
import com.example.application_envios.utils.AlertsHelper;
import com.example.application_envios.utils.PermissionHelper;

import javax.inject.Inject;

public abstract class BasicActivity extends AppCompatActivity {

    protected SharedPreferences sharedPreferences;
    protected LoadingDialog loadingDialog;
    @Inject
    PermissionHelper permissionHelper;
    @Inject
    AlertsHelper alertsHelper;
    @Inject
    LocationService locationService;
    @Inject
    RouterGoogleAPIService routerGoogleAPIService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ((App) getApplicationContext()).getAppComponent().inject(this);
        super.onCreate(savedInstanceState);
        loadingDialog = new LoadingDialog(this);
    }
}
