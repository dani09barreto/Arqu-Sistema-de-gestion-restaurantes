package com.example.envios_app.dependencies.modules;


import com.example.envios_app.utils.ResponseLB;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ResponseLBModule {
    @Singleton
    @Provides
    public ResponseLB provideResponseLB() {
        return new ResponseLB();
    }
}
