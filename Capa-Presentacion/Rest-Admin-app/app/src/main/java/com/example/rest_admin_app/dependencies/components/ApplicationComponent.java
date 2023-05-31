package com.example.rest_admin_app.dependencies.components;


import com.example.rest_admin_app.activites.BasicActivity;
import com.example.rest_admin_app.dependencies.modules.AlertsModule;
import com.example.rest_admin_app.dependencies.modules.LocationModule;
import com.example.rest_admin_app.dependencies.modules.PermissionModule;
import com.example.rest_admin_app.dependencies.modules.ResponseLBModule;
import com.example.rest_admin_app.dependencies.modules.RouterGoogleAPIModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AlertsModule.class, PermissionModule.class, LocationModule.class, RouterGoogleAPIModule.class, ResponseLBModule.class})
public interface ApplicationComponent {
    void inject(BasicActivity activity);
}
