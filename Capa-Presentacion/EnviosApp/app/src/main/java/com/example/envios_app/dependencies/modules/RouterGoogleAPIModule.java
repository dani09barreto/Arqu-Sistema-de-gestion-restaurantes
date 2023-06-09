package com.example.envios_app.dependencies.modules;

import com.example.envios_app.services.RouterGoogleAPIService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import lombok.AllArgsConstructor;

@Module
@AllArgsConstructor
public class RouterGoogleAPIModule {

    @Provides
    @Singleton
    public RouterGoogleAPIService provideRouterGoogleARIService (){
        return new RouterGoogleAPIService();
    }
}
