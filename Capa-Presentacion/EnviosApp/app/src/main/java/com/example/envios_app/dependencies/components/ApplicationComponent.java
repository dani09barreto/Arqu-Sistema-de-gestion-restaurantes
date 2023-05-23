package com.example.envios_app.dependencies.components;

import com.example.envios_app.activities.BasicActivity;
import com.example.envios_app.dependencies.modules.AlertsModule;
import com.example.envios_app.dependencies.modules.LocationModule;
import com.example.envios_app.dependencies.modules.PermissionModule;
import com.example.envios_app.dependencies.modules.RouterGoogleAPIModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AlertsModule.class, PermissionModule.class, LocationModule.class, RouterGoogleAPIModule.class})
public interface ApplicationComponent {
    void inject(BasicActivity activity);
}
