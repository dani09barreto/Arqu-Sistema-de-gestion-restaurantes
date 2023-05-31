package com.example.rest_admin_app;

import android.app.Application;

import com.example.envios_app.dependencies.components.ApplicationComponent;
import com.example.envios_app.dependencies.components.DaggerApplicationComponent;
import com.example.envios_app.dependencies.modules.LocationModule;

import lombok.Getter;

@Getter
public class App extends Application {
    ApplicationComponent appComponent = DaggerApplicationComponent.builder()
            .locationModule(new LocationModule(this))
            .build();
}
