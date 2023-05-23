package com.example.application_envios.dependencies.modules;


import com.example.application_envios.services.RouterGoogleAPIService;

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
