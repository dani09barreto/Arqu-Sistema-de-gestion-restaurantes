package com.example.envios_app.activities;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.envios_app.App;
import com.example.envios_app.activities.dialog.LoadingDialog;
import com.example.envios_app.services.LocationService;
import com.example.envios_app.services.RouterGoogleAPIService;
import com.example.envios_app.utils.AlertsHelper;
import com.example.envios_app.utils.PermissionHelper;
import com.example.envios_app.utils.ResponseLB;

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
}
