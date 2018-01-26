package de.dominikwieners.dan.base.modules;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dominikwieners on 15.01.18.
 */


@Module
public class AppModule {
    Application application;

    public AppModule(Application application){
        this.application = application;
    }

    @Provides
    @Singleton
    Application providedApplication(){
        return application;
    }
}
