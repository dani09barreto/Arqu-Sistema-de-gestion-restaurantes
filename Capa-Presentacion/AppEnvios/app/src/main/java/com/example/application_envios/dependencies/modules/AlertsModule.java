package com.example.application_envios.dependencies.modules;


import com.example.application_envios.utils.AlertsHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AlertsModule {
    @Singleton
    @Provides
    public AlertsHelper provideAlertHelper() {
        return new AlertsHelper();
    }
}
