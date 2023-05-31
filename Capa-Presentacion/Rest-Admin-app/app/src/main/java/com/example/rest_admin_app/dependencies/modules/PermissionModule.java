package com.example.rest_admin_app.dependencies.modules;

import com.example.envios_app.utils.PermissionHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class PermissionModule {

    @Singleton
    @Provides
    public PermissionHelper providePermissionHelper() {
        return new PermissionHelper();
    }
}