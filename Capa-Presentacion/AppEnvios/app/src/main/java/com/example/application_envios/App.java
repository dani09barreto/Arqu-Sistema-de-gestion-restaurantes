package com.example.application_envios;

import android.app.Application;


import com.example.application_envios.dependencies.components.ApplicationComponent;
import com.example.application_envios.dependencies.components.DaggerApplicationComponent;
import com.example.application_envios.dependencies.modules.LocationModule;

import lombok.Getter;

@Getter
public class App extends Application {
    ApplicationComponent appComponent = DaggerApplicationComponent.builder()
            .locationModule(new LocationModule(this))
            .build();
}
