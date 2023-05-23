package com.example.application_envios.dependencies.components;


import com.example.application_envios.activities.BasicActivity;
import com.example.application_envios.dependencies.modules.AlertsModule;
import com.example.application_envios.dependencies.modules.LocationModule;
import com.example.application_envios.dependencies.modules.PermissionModule;
import com.example.application_envios.dependencies.modules.RouterGoogleAPIModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AlertsModule.class, PermissionModule.class, LocationModule.class, RouterGoogleAPIModule.class})
public interface ApplicationComponent {
    void inject(BasicActivity activity);
}
