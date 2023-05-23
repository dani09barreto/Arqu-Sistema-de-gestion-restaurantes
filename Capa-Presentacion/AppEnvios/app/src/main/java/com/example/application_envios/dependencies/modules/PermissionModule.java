package com.example.application_envios.dependencies.modules;


import com.example.application_envios.utils.PermissionHelper;

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